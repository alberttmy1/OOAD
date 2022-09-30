/*
* Decorator Pattern:
* We have subclasses for every type of celebration and our default initiates shout
 */

//initiate the interface and create a public function that returns back a string called celeb()
public interface Celebrate{
    public String celeb();

}
//Default case that implements shout to celeb()
class standardCeleb implements Celebrate{
    @Override
    public String celeb(){
        //System.out.println("shout");
        return "Shout,";
    }
}
//The decorator that will update celeb()
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

//add jump to the celeb() function
class jump extends celebrateDecorator{

    public jump(Celebrate fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Jump,";
    }
}

//add spin to the celeb() function
class spin extends celebrateDecorator{


    public spin(Celebrate fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Spin,";
    }
}

//add dance to the celeb() function
class dance extends celebrateDecorator{


    public dance(Celebrate fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Dance,";
    }
}
