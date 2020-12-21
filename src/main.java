import java.util.Arrays;



class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        int length = phone_book.length;

        for(int i=0; i<length-1; i++){
            String startNumber = phone_book[i];
            String compareNumber = phone_book[i+1];
            if(compareNumber.startsWith(startNumber))
                return false;
        }

        return true;
    }
}