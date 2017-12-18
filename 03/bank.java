class BankAccount {
    long value;
    synchronized long balance() { return value; }
    synchronized void deposit(long n) { value += n; }
    synchronized void withdraw(long n) { value -= n; }

    /*(a)*/ void transfer(BankAccount other,long n) {
        if ( other == this )//引数のアカウントが自身であったら
            return;//変更する必要がないためそのまま
        else if ( System.identityHashCode(this) < 
             System.identityHashCode(other) )
            this.doTransfer(other,n);
        else
            other.doTransfer(this,n);
    }
    synchronized void doTransfer(BankAccount other,long n) {//使用するリソースをまとめてロックする
        /*(h)*/
      //  if(balance()>=n){
            withdraw( n );
            other.deposit(n);
       // }
    }
}


class Thread_A implements Runnable{
    BankAccount b,other;

    Thread_A(BankAccount b){
        this.b=b;
    }
    public void run(){
        try{
            b.transfer(other,10000);

        }catch(InterruptedException e){
            System.err.println("Thread_A():Interrupted");
        }
    }
}
/*
class Thread_B implements Runnable{
    BankAccount b,other;

    Thread_B(BankAccount b,BankAccount a){
        this.b=b;
        this.other=a;
    }
    public void run(){
        try{
            b.transfer(other,1000);
        }catch(InterruptedException e){
            System.err.println("Thread_B():Interrupted");
        }
    }
}
*/
class CircularBufferDemo
{
    public static void main(String argv[])
    {
    final BankAccount b = new BankAccount();
    Thread t1 = new Thread( new Thread_A(b)  );
    t1.start();
    //Thread t2 = new Thread( new Thread_B(b) ,new Thread_A(b));
    //t2.start();
    try
    {
        //t1.deposit(1000);
        //System.out.println("t1 has "+t1.balance);
        t1.join();
      //  t2.join();

    }
    catch( InterruptedException e )
    {
        System.err.println("main(): Interrupted");
    }
    }
}