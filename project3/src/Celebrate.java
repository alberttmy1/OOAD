
public interface Celebrate{
    public String celeb();

}
class standardCeleb implements Celebrate{
    @Override
    public String celeb(){
        //System.out.println("shout");
        return "Shout,";
    }
}
class celebrateDecorator implements Celebrate{
    protected Celebrate fire;
    public celebrateDecorator(Celebrate f){
        this.fire = f;
    }
    @Override
    public String celeb(){
        return this.fire.celeb();
    }
}
class jump extends celebrateDecorator{

    public jump(Celebrate fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Jump,";
    }
}

class spin extends celebrateDecorator{


    public spin(Celebrate fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Spin,";
    }
}

class dance extends celebrateDecorator{


    public dance(Celebrate fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Dance,";
    }
}
