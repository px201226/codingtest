package boj.line05;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] rules = new String[]{"-s STRING", "-n NUMBER", "-e NULL"};
        String[] command = new String[]{"line -n 100 " +
                "-n 100 -s hi -e", "dd"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("line", rules, command)));
    }

    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        Program programLine = new Program(program, flag_rules);

        for(int i=0; i<commands.length; i++){
            answer[i] = programLine.getCommandValidation(commands[i]);
        }

        return answer;
    }

}

// 플래그 아규먼트 타입이 가지는 아규먼트 갯수를 저장하는 Enum
enum FlagArgumentType{
    STRING(1, new ValidatorTypeString()),
    NUMBER(1, new ValidationTypeNumber()),
    NULL(0, new ValidatorTypeNULL());

    int argumentNumber;
    Validateable validateable;
    FlagArgumentType(int argumentNumber, Validateable validateable) {
        this.argumentNumber = argumentNumber;
        this.validateable = validateable;
    }

    public int getArgumentNumber(){
        return argumentNumber;
    }
    public Validateable getValidatealbe() {return validateable;}
}

// Type Rule Validation 인터페이스
interface Validateable {
    public boolean valid(String input);
}

/* CLI 프로그램 클래스
 프로그램 이름과, 플래그 이름에 해당하는 타입을 저장한다.
* */
class Program {

    // 프로그램의 이름
    private String name;

    // 프로그램이 사용 가능 한 flag 들의 룰들
    // ex : ["-e","NULL"] , ["-n "NUMBER"]
    private Map<String, FlagArgumentType> flagArgTypeByFlagNames = new HashMap<>();

    public Program(String name, String[] flagRules) {
        this.name = name;

        for(String flagRule : flagRules){
            String[] splitFlagRule = flagRule.split(" ");

            // 플래그 룰을 추가
            flagArgTypeByFlagNames.put(splitFlagRule[0], FlagArgumentType.valueOf(splitFlagRule[1]));
        }
    }

    // 사용자가 프로그램에 대한 입력이 올바른지 확인한다.
    public boolean getCommandValidation(String command) {
        return hasEqualProgram(command) && getRuleFlagValidation(command);
    }

    // 사용자가 입력한 명령어의 프로그램이 클래스의 프로그램과 일치한지 검사한다.
    private boolean hasEqualProgram(String command) {
        if (command.equals("")) return false;
        String programEnteredCommand = command.split(" ")[0];
        return name.equals(programEnteredCommand);
    }

    // 사용자가 입력한 명령어의 플래그 옵션들이 룰과 일치한지 검사한다.
    private boolean getRuleFlagValidation(String command) {

        boolean validation = true;
        String[] splitCommand = command.split(" ");

        // i는 사용자 입력 중 flag_name 에 해당하는 블록만을 가르킨다.
        int pointerFlagName = 1;
        while (pointerFlagName < splitCommand.length) {

            String flagName = splitCommand[pointerFlagName];

            // flagName 이 일반 아규먼트면 false
            if(!isFlagName(flagName)){
                validation = false;
                break;
            }

            FlagArgumentType flagArgumentType = flagArgTypeByFlagNames.get(flagName);
            if(flagArgumentType == null){
                validation = false;
                break;
            }

            // flagName을 이용하여 Validator와 해당 flagName의 피연산자수와, 피연산자수에 맞는 입력을 구한다.
            Validateable validator = flagArgumentType.getValidatealbe();
            int numberOperand = flagArgumentType.getArgumentNumber();
            String input = getInputOfFlagType(splitCommand, pointerFlagName, numberOperand);

            if(!validator.valid(input)){
                validation = false;
                break;
            }

            // flagName의 해당하는 피연산자수 +1 만큼 이동
            pointerFlagName = pointerFlagName+numberOperand+1;

        }

        return validation;
    }

    private int getArgumentNumber(String flagName) {
        FlagArgumentType flagArgumentType = flagArgTypeByFlagNames.getOrDefault(flagName, FlagArgumentType.NUMBER);
        return flagArgumentType.getArgumentNumber();
    }

    private String getInputOfFlagType(String[] splitCommand, int curIndex, int numberOperand) {
        StringBuilder input = new StringBuilder();
        for(int j=1; curIndex+j<splitCommand.length && j<=numberOperand; j++)
            input.append(splitCommand[curIndex+j]);
        return input.toString();
    }

    private boolean isFlagName(String flagName) {
        return flagName.charAt(0) == '-';
    }

}


class ValidatorTypeNULL implements Validateable {
    @Override
    public boolean valid(String input) {
        if(input == null)
            return true;

        if(input.equals(""))
            return true;

        return false;
    }
}

class ValidatorTypeString implements Validateable {
    @Override
    public boolean valid(String input) {
        boolean isAlphabet = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isAlphabetic(input.charAt(i))) {
                isAlphabet = false;
                break;
            }
        }
        return isAlphabet;
    }
}

class ValidationTypeNumber implements Validateable {
    @Override
    public boolean valid(String input) {
        boolean isNumber = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isNumber = false;
                break;
            }
        }

        return isNumber;
    }
}
