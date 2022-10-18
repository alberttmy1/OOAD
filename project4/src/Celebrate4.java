/*
* Decorator Pattern:
* We have subclasses for every type of celebration and our default initiates shout
 */

//initiate the interface and create a public function that returns back a string called celeb()
public interface Celebrate4{
    public String celeb();

}
//Default case that implements shout to celeb()
class standardCeleb4 implements Celebrate4{
    @Override
    public String celeb(){
        //System.out.println("shout");
        return "Shout,";
    }
}
//The decorator that will update celeb()
class celebrateDecorator4 implements Celebrate4{
    protected Celebrate4 fire;
    public celebrateDecorator4(Celebrate4 f){
        this.fire = f;
    }
    @Override
    public String celeb(){
        return this.fire.celeb();
    }
}

//add jump to the celeb() function
class jump4 extends celebrateDecorator4{

    public jump4(Celebrate4 fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Jump,";
    }
}

//add spin to the celeb() function
class spin4 extends celebrateDecorator4{


    public spin4(Celebrate4 fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Spin,";
    }
}

//add dance to the celeb() function
class dance4 extends celebrateDecorator4{


    public dance4(Celebrate4 fire){
        super(fire);
    }
    @Override
    public String celeb(){
        return this.fire.celeb() + "Dance,";
    }
}
