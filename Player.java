import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bunny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private GreenfootImage gameover = new GreenfootImage("gameover.png");
    private int downSpeed = 0;
    private int acceleration = 2;
    private int jumpPower = 3;
    private int lives = 3;
    private int score;
    private int getCoin;
    private int timer;
    public void act()
    {
        playerMove();
        playerFall();
        checkFalling();
        hitCar();
        hitBird();
        showStatus();
        Coin();
        updateTimer();
        finish();
    }
    
    public Player(){
        setImage("images/bunny.png");
        GreenfootImage image = getImage();
        image.scale(50,50);
        timer = 1000;
    }
    
    public void playerMove()
    {
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+3, getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-3, getY());
        }
        if(Greenfoot.isKeyDown("space")){
            jump();
            fall();
        }
    }
    
    boolean onGround() 
    {
        Actor under = getOneObjectAtOffset (0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    
    public void checkFalling()
    {
        if(onGround() == false)
        {
            fall();
        }
        if(onGround() == true)
        {
            downSpeed = 0;
        }
        
    }
    
    public void jump(){
        downSpeed = -jumpPower;
        fall();
    }
    
    public void playerFall(){
        if(onGround()){
            downSpeed = 0;
        }else{
            fall();
        }
    }
    
    public void fall()
    {
        setLocation (getX(), getY() + downSpeed);
        downSpeed = downSpeed + acceleration;
    }
    
    public void hitCar()
    {
        if(isTouching(Car.class)){
            Greenfoot.playSound("enemy.mp3");
            setLocation(100,300);
            removeLife();
        }
    }
    
    public void hitBird()
    {
        if(isTouching(Bird.class)){
            Greenfoot.playSound("enemy.mp3");
            setLocation(100,300);
            removeLife();
        }
    }
    
    public void finish()
    {
        if(getCoin == 5 && isTouching(Flag.class)){
            setLocation(100,300);
            getCoin = 0;
            upScore();
            MyWorld myworld = (MyWorld)getWorld();
            myworld.upLevel();
            timer = 1000;
        }
    }
    
    public void Coin()
    {
        if(isTouching(Coin.class)){
            Greenfoot.playSound("error.mp3");
            removeTouching(Coin.class);
            getCoin++;
            upScore();
            timer = timer + 200;
        }
    }
    
    public void removeLife()
    {
        lives--;
        timer = 1000;
        showStatus();
        endGame();
    }
    
    public void endGame()
    {
        if (lives <= 0)
        {
            setImage(gameover);
            GreenfootImage image = getImage();
            Greenfoot.playSound("gameover.wav");
            image.scale(300,300);
            setLocation(600, 180);
            Greenfoot.stop();
        }
    }
    
    public void upScore(){
        score++;
        showStatus();
    }
    
    public void showStatus()
    {
        getWorld().showText("Lives = "+lives, 1100, 30);
        getWorld().showText("Score = "+score, 1100, 50);
    }
    
    public void updateTimer(){
        timer--;
        getWorld().showText("Time = "+timer, 100, 30);
        if(timer < 1){
            removeLife();
        }
    }

}

