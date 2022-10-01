package leetcode;

/**
 *
 * @Sir Darey
 */

class _838_PushDominoes {
    
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int left = 0, right = 0;
        char [] result = dominoes.toCharArray();
        
        while (right < n) {
            char c = dominoes.charAt(right);
            
            if (c == '.' && right+1 < n) {
                right++;
                continue;
            }
            
            int i = left, j = right;
            
            if (c == 'L') {
                if (dominoes.charAt(i) == '.') {
                    while (i < j) {
                        result[i] = 'L';
                        i++;
                    }
                } else if(dominoes.charAt(i) == 'R') {
                    while(i+1 < j-1) {
                        result[i+1] = 'R';
                        result[j-1] = 'L';
                        i++; j--;
                    }
                }
                
                left = right = right+1;
                
            } else {
                if (dominoes.charAt(i) == 'R') {
                    while(i <= j) {
                        result[i] = 'R';
                        i++;
                    }
                }
                left = right;
                right = right+1;
            }
        }
        return new String(result);
    }
}