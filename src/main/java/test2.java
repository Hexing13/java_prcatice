/**
 * Created by hexing on 15-7-7.
 */
class test2 {
    public static void main(String[] args) {
        try {
            System.out.println(Sum.addContinue(5));
            System.out.println(Sum.addContinue(-1));
        } catch (ArgumentException e) {
            System.out.println("错误的n："+e.get());
        }
    }
}

class Sum{
    public static int addContinue(int n) throws ArgumentException {
        if(n < 0) throw new ArgumentException(n);
        return n*(n+1)/2;
    }
}

class ArgumentException extends Exception{
    private int n;
    public ArgumentException(int n){
        this.n = n;
    }
    public int get(){
        return n;
    }
}

