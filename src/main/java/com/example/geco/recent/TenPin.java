package com.example.geco.recent;

public class TenPin {
    public static void main(String[] args) {
        int res=bowling_score("X X X X X X X X X XXX");
        System.out.print(res);
    }
        static int score=0;
        public static int bowling_score(String str) {
            String[] frames= str.split(" ");
            // Frame 0-8
            int cursor=0;
            for(int i=0;i<9; i++){
                String curFrame=frames[i];
                if(isStrike(curFrame)){
                    score+=10 +getStrikeBonus(i+1, frames);
                    cursor++;
                }else if(isSpare(curFrame)){
                    score+= 10+ getSpareBonus(frames[i+1]);
                    cursor+=2;
                }else{
                    score+=getFrameScore(curFrame);
                }
            }

            //Frame 9. Last frame
            String last=frames[9];
            if("XXX".equals(last)){//XXX
                score+=30;
            }else if(isSpare(last)){//9/
                score+=10;
            }else if(last.contains("X")){//X9
                score+=10+last.charAt(1)-'0';
            }else{//9
                score+=last.charAt(0)-'0';
            }
            return score;
        }

        private static int getStrikeBonus(int index, String [] frames){
            if("X".equals(frames[index])){
                return 10+ ("X".equals(frames[index+1])?10: getPinValue(frames[index+1]));
            }else if(index<8){
                return isSpare(frames[index])? 10: getFrameScore(frames[index]);
            }else{
                return getPinValue(frames[index+1]);
            }
        }
        private static int getPinValue(String pin){
            return pin.charAt(0)-'0';
        }
        private static int getFrameScore(String frame){
            int num=0;
            for(char c: frame.toCharArray()){
                num+=c-'0';
            }
            return num;
        }

        private static int getSpareBonus(String frame){
            return isStrike(frame)?10:frame.charAt(0)-'0';
        }

        private static boolean isSpare(String frame){
            return frame.contains("/");
        }
        private static boolean isStrike(String frame){
            return frame.equals("X");
        }
}
