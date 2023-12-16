import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int inLevel = 1;
    public MyWorld()
    {    
        super(1200, 360, 1);
        addObject(new Player(), 100, 300);
        addObject(new Car(), 350, 300);
        addObject(new Rock(), 1000, 305);
        addObject(new Car(), 600, 300);
        addObject(new Car(), 850, 300);
        addObject(new Coin(), 400, 200);
        addObject(new Coin(), 600, 200);
        addObject(new Coin(), 800, 200);
        addObject(new Coin(), 930, 150);
        addObject(new Coin(), 1000, 200);
        addObject(new Flag(), 1150, 300);
        addObject(new Ground(), 0, 350);
        addObject(new Ground(), 300, 350);
        addObject(new Ground(), 600, 350);
        addObject(new Ground(), 900, 350);
    }
    public void setUpLevel(){
        if(inLevel == 2){
            addObject(new Bird(), 500, 120);
            addObject(new Bird(), 800, 120);
            addObject(new Car(), 1050, 300);
            addObject(new Coin(), 400, 200);
            addObject(new Coin(), 600, 200);
            addObject(new Coin(), 800, 200);
            addObject(new Coin(), 930, 150);
            addObject(new Coin(), 1000, 200);
        }else if(inLevel == 3){
            addObject(new Bird(), 1000, 100);
            addObject(new Rock(), 650, 305);
            addObject(new Coin(), 400, 200);
            addObject(new Coin(), 600, 200);
            addObject(new Coin(), 800, 200);
            addObject(new Coin(), 930, 150);
            addObject(new Coin(), 1000, 200);
        }
    }
    
    public void upLevel(){
        inLevel++;
        setUpLevel();
    }
}
