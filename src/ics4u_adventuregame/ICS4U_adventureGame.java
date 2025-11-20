ad /*
    DYLAN THAI
    MRS GERVASIO
    ICS4U
    7 MAR 2025
    TITLE: Cavebound
    You play as yourself. You're trapped in a cave after the entrance became blocked behind you.
    You navigate through the orc dominated cave trying to figure out how to escape, not fully aware of what lies ahead
*/
package ics4u_adventuregame;
//scanner is used to take player input/decision
import java.util.Scanner;
//Thread is imported to use sleep to pause code and allow user to read
import java.lang.Thread;
public class ICS4U_adventureGame {
    //throws interrupted exception is needed for sleep import
    public static void main(String[] args)throws InterruptedException {
        //create scanner object
        Scanner input = new Scanner(System.in);
        //create color constants, used to create colored text
        String RESET = "\u001B[0m";
        //red represens major actions
        String RED = "\u001B[31m";
        //green is used for important statements
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        //playerSelection will be the main variable, updated as the player makes decisions in game
        int playerSelection = 0;
        boolean hasPaper = false, hasKilled = false, orcsFriendly=false, hasRing=false, inWaterCave=false;
        String playerAnswerString;
        int playerAnswerInt;
        //Prints out title
        System.out.println("   _____     __      ________ ____   ____  _    _ _   _ _____  \n  / ____|   /\\ \\    / /  ____|  _ \\ / __ \\| |  | | \\ | |  __ \\ \n | |       /  \\ \\  / /| |__  | |_) | |  | | |  | |  \\| | |  | |\n | |      / /\\ \\ \\/ / |  __| |  _ <| |  | | |  | | . ` | |  | |\n | |____ / ____ \\  /  | |____| |_) | |__| | |__| | |\\  | |__| |\n  \\_____/_/    \\_\\/   |______|____/ \\____/ \\____/|_| \\_|_____/ ");
        System.out.println("-------------------------------------------------------------------------------");
        //Adds pauses to the code, makes it easier for player to read
        System.out.println("Welcome to Cavebound, an interactive story game where you are trapped in a cave. Will you find a way out?\nHOW TO PLAY: Read the prompt and enter the corresponding number to make your choice! If you enter an invalid answer, reset the game.\n");
        Thread.sleep(2000);
        //DECISION 1 - left or right
        System.out.println(RED + "You enter the cave" + RESET +"\nA rock shifts, and suddenly, the entrance becomes blocked with giant pieces of rubble.\nUnwilling to die, you travel further into the cave\n\nYou are greeted by a fork in the road\nWhich way do you travel? (Enter corresponding number)");
        
        System.out.println("(1) Left");
        System.out.println("(2) Right\n");
        
        System.out.print(">");
        playerSelection = input.nextInt();
        switch(playerSelection){
            //DECISION 2 - In Study room
            case 1:
                System.out.println("---");
                System.out.println("You "+RED+"travel left"+RESET+" to find a decrepit" + RED + " study room " + RESET +"of sort. You notice a pair of footprints leading somewhere.\nDo you..\n");
                System.out.println("(1) Follow the footprints");
                System.out.println("(2) Attempt to search the room\n");
        
                System.out.print(">");
                playerSelection = input.nextInt();
                //attempt to search room
                if(playerSelection == 2){
                    System.out.println("---");
                    System.out.println("You dust off the walls to find a riddle reading:"+ GREEN +" \"What has to be broken before you can use it?\""+ RESET+"\n(hint: the answer is formatted as follows:\"an ___\" in ALL LOWERCASE\n");
                    System.out.print(">");
                    //another next line is needed to force cursor to end of string**(as shown in lesson 3)
                    input.nextLine();
                    playerAnswerString = input.nextLine();
                    //If you get answer correct,the code will break and you will enter village with note
                    if (playerAnswerString.equals("an egg")){
                        System.out.println("---");
                        System.out.println(GREEN+"\nCorrect!"+RESET+" A drawer flies open, and inside you find a note you don't understand.");
                        hasPaper = true;
                        Thread.sleep(3000);
                        break;
                    }
                    //Of you do not get answer, the code will break and you will enter the village without the paper
                    else{
                        System.out.println("---");
                        System.out.println("\nIt seems to have"+RED+" rejected"+RESET+" your answer as nothing happens...\nYou return to the study room.");
                        Thread.sleep(2000);
                        break;
                    }
                }
                //DECISION 3 - What to do about man.
                //Runs if you do not decide to search room
                System.out.println("---");
                System.out.println("You "+RED+"follow the footsteps"+RESET+" and find a old, dishevled man, he seems weak and vulnerable...\n");
                System.out.println("(1) Attempt to Befriend.");
                System.out.println("(2) Threaten with knife.\n");
        
                System.out.print(">");
                playerSelection = input.nextInt();
                switch(playerSelection){
                    case 1:
                        //DECISION 4 - Give water?
                        System.out.println("---");
                        System.out.println("You attempt to"+RED+" befriend the man"+RESET+", but hes in dire need of water... What do you do?");
                        System.out.println("(1) Give him water.");
                        System.out.println("(2) Refuse to give water.\n");
                        
                        System.out.print(">");
                        playerSelection = input.nextInt();
                        //don't give water
                        if (playerSelection == 2){
                            System.out.println("\nThe man begs for water, yet "+RED+"you refuse"+RESET+". He dies shortly later, drying up like a leaf in the fall...");
                            hasKilled=true;
                            Thread.sleep(5000);
                            //Breaks out of cases, you will enter village with orcs aware of your murder
                            break;                         
                        //give water
                        } 
                        else if(playerSelection == 1){
                            //DECISION 5
                            System.out.println("---");
                            System.out.println("He "+RED+"thanks you for the water"+RESET+" and for saving him. He formally introduces himself as an Orc Scientist, specializing in... Orcs\nYou explain your situation and he claims that he has a map and knows where to bring you!");
                            System.out.println("What do you do?");
                            System.out.println("(1) Trust him and follow him");
                            System.out.println("(2) Try to lie and take the map!\n");
                        
                            System.out.print(">");
                            playerSelection = input.nextInt();
                        }
                            //DECISION 5-  Trust orc scientiist?
                            //BEST BUDDIES ENDING
                            if(playerSelection == 1){
                                System.out.println("\nWith a smile, you"+RED+" decide to trust him"+RESET+".\nHe nods and, without a word, he leads you out the room through the cave.");
                                Thread.sleep(2000);
                                System.out.println("With his thirst quenched, he ran back to his study room and returned with a piece of paper.\nHe faces what seemed to be a regular stone wall.\nHe chanted in Latin and waved the paper... ");
                                Thread.sleep(2000);
                                System.out.println("With a boom, the regular brick walls slammed open, allowing you to escape.\n\nYou escaped! You got the "+YELLOW+"BEST BUDDIES ending");
                                System.exit(0);
                            }
                            //TRUST ISSUES ENDING
                            else if (playerSelection==2){
                                System.out.println("---");
                                System.out.println("You "+RED+"attempt to pose as a orc scientist yourself"+RESET+", but the man is well aware of who is a scientist and who is not! Thinkiing that you're an orc, he STABS you.\n\nYou died! You got the TRUST ISSUES ending.");
                                System.exit(0);
                            }
                        break;
                    case 2:
                        System.out.println("---");
                        System.out.println("You "+RED+"pull out your pocket knife"+RESET+" trying to threaten him into telling you anything...\nThe old man suddenly collapsed! He stopped responding to your questions...");
                        Thread.sleep(2000);
                        hasKilled=true;
                        break;       
                }
                
                
                break;
            //Right pathway
            case 2:
                //DECISION 2 - hide in water or follow breathing
                System.out.println("---");
                System.out.println("You"+RED+" travel right "+RESET+"to find a larger cave with a body of water\nSuddenly, you hear breathing.\nWhat do you do?\n");
                System.out.println("(1) Hide in water ");
                System.out.println("(2) Follow the breathing\n");
                System.out.print(">");
                playerSelection = input.nextInt();
                //DECISION 3 - Approach shining object or ignore object
                if(playerSelection==1){
                    System.out.println("---");
                    System.out.println("\nYou "+RED+"slip into the water"+RESET+", with only a breath of oxygen.\nIn the water, you notice a faint light.\nWhat do you do?\n");
                    System.out.println("(1) Try and approach the shining object(RISKY)");
                    System.out.println("(2) Ignore the object and let the orc pass.\n");
                
                    System.out.print(">");
                    playerSelection = input.nextInt();
                    //attempt to swim for shiny object: Skill event, must get answer correct to proceed, punishment is death
                    if(playerSelection==1){
                        System.out.println("---");
                        System.out.println("You "+RED+"swim towards the object"+RESET+", it appears to be a ring.\n\nTo grab the ring and make it out, answer the following question!"+GREEN+"\nWhich is not a tourist location in Toronto?\n1.CN tower\n2.The Eiffel Tower\n3.Ripley's Aquarium.\n4.The ROM\n"+RESET);
                        System.out.print(">");
                        playerSelection = input.nextInt();
                        //DECISION 4 - What to do with ring
                        if (playerSelection==2){
                            System.out.println("---");
                            System.out.println("You "+RED+"dive down and reach the ring!"+RESET);
                            System.out.println("With the ring in hand, and the orc long gone, you jump out of the water.\nYou look at the ring, it has an ominous aura to it.\nYou question whether or not you should put the ring on.\nWhat do you do?\n");
                            System.out.println("(1)Put on the ring");
                            System.out.println("(2)Throw the ring out\n");
                
                            System.out.print(">");
                            playerSelection = input.nextInt();
                            //MAGICAL RING ENDING
                            if(playerSelection==1){
                                System.out.println("---");
                                System.out.println("You "+RED+"put on the ring "+RESET+" and you wave your hands around to admire it.\nSuddenly you feel a strong downwards force push through your body!\nYou close your eyes in fear, but you're surprised to suddenly feel the sun against your skin.\nThe ring disappeared and you've escaped the cave!\n\nYou escaped! You got the"+YELLOW+" MAGICAL RING ending.");
                                System.exit(0);
                            }
                            else if(playerSelection==2){
                                System.out.println("---");
                                System.out.println("You "+RED+"throw the ring back into the water"+RESET+", scared of what it might do to you...");
                                //inWaterCave is used to make two pathways meet by breaking out the switch statement to path code to a common/shared if statement
                                inWaterCave=true;
                            }
                        }
                        //DROWNED ENDING
                        else{
                            System.out.println("---");
                            System.out.println("You "+RED+"dive down"+RESET+" and reach out with all your might, but to no avail.\n\nYou died! You got the "+YELLOW+"DROWNED ending!");
                            System.exit(0);
                        }
                    }
                    //Doesn't go for shiny object
                    else if(playerSelection==2){
                        System.out.println("---");
                        System.out.println(RED+"You take the safer route"+RESET+", refusing to risk your life for some shiny object.");
                        inWaterCave=true;                  
                    }
                }
                //Attempt to follow breathing
                else if(playerSelection==2){
                    System.out.println("---");
                    System.out.println("You "+RED+"follow the breathing+"+RESET+" and see a rather weak looking orc.\nYou feel that you could likely scare it.\n");
                    //DECISION 3 - attempt to communicate or scare
                    System.out.println("What do you do?\n");
                    System.out.println("(1) Attempt to communicate");
                    System.out.println("(2) Scare the orc\n");
                    System.out.print(">");
                    playerSelection = input.nextInt();
                    //DECISION 4 - TRUST ORC OR THREATEN
                    if(playerSelection==1){ 
                        System.out.println("---");
                        System.out.println("The orc turns around with a polite gesture.\nIt seems to pity you considering your condition, and he brings you to a village\nYou are presented infront of the Orc Leader\nWhat do you do?\n");
                        System.out.println("(1)Threaten");
                        System.out.println("(2)Submit and pray\n");
                        System.out.print(">");
                        playerSelection = input.nextInt();
                        //NOBLE(?) ENDING
                        if(playerSelection==1){
                            System.out.println("---");
                            System.out.println("You "+RED+"spit on the orc with pride!"+RESET+"\nYou refuse to listen to the orc and you pull out your pocket knife.\nThe Orc leader doesn't react, and suddenly an arrow passes through your chest.\n\nYou died! You got the "+YELLOW+"PRIDEFUL ending!");
                            System.exit(0);
                        //ORC BUDDY ENDING
                        } 
                        else if(playerSelection==2){
                            System.out.println("---");
                            System.out.println("You "+RED+"praise and beg the Orc leader for help"+RESET+"\nThe orc who presented you to the king vouched for you aswell.\nThe leader decided to bring you back to the blocked entrance you came in from.\nSuddenly he smashes the rubble in the way, allowing you to leave. You give the orcs a handshake and leave.\nYou escaped! You got the"+YELLOW+" ORC BUDDY ending!");
                            System.exit(0);
                        }
                    }
                    //Scareprc
                    else if(playerSelection==2){
                        System.out.println("---");
                        System.out.println(RED+"You let out a roar!"+RESET+"\n\nThe orc runs away, leaving behind a wooden club.\nYou decide to take the club, maybe it would come in handy.");
                        System.out.println("You venture down the cave, wooden club in hand, and you come across a small village of orcs.\nThis has to be where the orcs reside!\nIf anyone knows a way out, they would.\nAlthough, they don't seem to be very eager to help a human like you.");
                        //DECISION 5 - sneak into village or barge in?
                        System.out.println("What should you do?\n");
                        System.out.println("(1)Sneak into the village.");
                        System.out.println("(2)Go in gun's blazing!\n");
                        System.out.print(">");
                        playerSelection = input.nextInt();
                        //Sneak in
                        if(playerSelection==1){
                            System.out.println("---");
                            System.out.println("Leaving your club behind, you opt to "+RED+"sneak into the village"+RESET+", evading the orc patrol. You manage to steal a map and a human to orc translator. Convienient!");
                            System.out.println("With all this, you can probably escape, but you're tempted to steal some gold from their treasurey while you're sneaking in.\nWhat do you do?");
                            System.out.println("(1)Don't steal.");
                            System.out.println("(2)Steal... just one gold coin.\n");
                            System.out.print(">");
                            playerSelection = input.nextInt();
                            //DECISION 6 Steal or Don't steal
                            //Steal
                            if(playerSelection==1){
                                System.out.println("---");
                                //NINJA ENDING
                                System.out.println("You leave the village, "+RED+"without a coin"+RESET+".\nUsing the map, you find yourself at a regular wall, but the orc translator has a \"Master Code\" written on it.\n You read the master code into the translator and it spews out orc-ish language.\nThe regular walls suddenly split open.\n\nYou escaped! You got the "+YELLOW+"NINJA ending!");
                                System.exit(0);
                            }
                            //Steal
                            else if(playerSelection==2)
                                System.out.println("---");
                                //PRISONER ENDING
                                System.out.println("You "+RED+"reach for a gold coin."+RESET+"\nBut suddenly, the coins began to all flow down the pile, making a loud waterfall-esque noise!\nThe orcs find you and arrest you.\nYou're locked in orc jail for the rest of eternity\n\nYou didn't escape... You got the"+YELLOW+" PRISONER ending!");
                                System.exit(0);
                        }
                        //Go out guns blazing
                        if(playerSelection==2){
                            //IDIOT ENDING
                            System.out.println("---");
                            System.out.println(RED+"You go out guns blazing..!"+RESET+" equipped with only your wooden club.\nI'm not sure what you were thinking.\nThe orcs beat you to bits.\n\nYou died! You got the"+YELLOW+" IDIOT ending!");
                            System.exit(0);
                        }
                        
                    }
                }
                break;
        }
        //This code below is for playesr who have A. killed the man, B. Failed/Solved the first riddle.
        //DECISION 3 IF YOU THREATENED HUMAN, DECISION 4 IF YOU REFUSED TO GIVE WATER TO HUMAN, BOTH ENDINGS ARE EARLY LOSS ENDINGS
        //If you travelled right, this pathway will not be available
        if(hasKilled==true && hasRing==false){
            System.out.println("---");
            System.out.println("With no option, "+RED+"you venture down the cave... alone..."+RESET+"\nAfter some time, you find what seems to be a village inhabited by orcs.\nSuddenly an orc appears, but it doesn't attack you.");
            System.out.println("The orc cries out, and suddenly a heavily armored orc appears. He does not look happy.");
            System.out.println("The orc holds a picture of him and the man you saw... \nHe seems to have known what you did, holding the blade to your neck");
            Thread.sleep(5000);
            System.out.println("\nRealizing your dire situation, what do you do?\n");
            //DECISION 3/4
                System.out.println("(1) Pull out pocket knife. ");
                System.out.println("(2) Attempt to convince the orc leader\n");
                System.out.print(">");
                playerSelection = input.nextInt();
                if(playerSelection==1){
                    System.out.println("---");
                    System.out.println("You manage to create some distance with your "+RED+"pocket knife"+RESET+", even grabbing a bystander as a hostage\nBut suddenly, the bystander grabs your knife and crushes it to pieces\nWho would've thought these orcs were THAT strong.\nThe orc pushes you to the floor, and the orcs start kicking you mericlessly killing you after some time...\n\nYou die! You got the"+YELLOW+" PATHETIC ending.");
                    System.exit(0);
                }
                else{
                    System.out.println("---");
                    System.out.println(RED+"You start to cry and beg for mercy"+RESET+". However, the orc knows that you showed that weak man no mercy... \nThe orc king does not hesitate to slice your head off.\n\nYou die! You got the "+YELLOW+"KARMA ending");
                    System.exit(0);
                }  
        }
        //You do not have paper and you have not killed till this point
        else if(hasKilled==false && hasPaper==false && hasRing==false && inWaterCave==false){
            System.out.println("---");
            System.out.println(RED+"You try to backtrack and folllow the footsteps"+RESET+", but they lead no where\nWith no option, you venture down the cave... alone...\nAfter some time, you find what seems to be a village inhabited by orcs.\nSuddenly an orc appears, but it doesn't attack you.\nHe grabs you and takes you to a large building.\nIt seems to be a townhall.\nYou're greeted by a giant armored goblin.\n");
            System.out.println("The orc questions you and you explain your situation.\nThey're willing to help as long as you can solve an extremely, advanced math problem for the orcs.");
            Thread.sleep(7000);
            System.out.println("The orcs hand you a scroll reading:"+GREEN+" 3+4(3*4)"+RESET);
            System.out.print("\nThe answer is: ");
            playerAnswerInt = input.nextInt();
            if (playerAnswerInt==51){
                System.out.println("---");
                System.out.println("\nThe orc's jaw drops as he realizes you "+RED+"solved the math problem correctly!"+RESET+" Turns out they're not that smart...");
                orcsFriendly=true;
                Thread.sleep(2000);
            }
            //F-STUDENT ENDING
            else{
                System.out.println("---");
                System.out.println("\nThe goblin laughs as he throws you out the village! You try to continue through the cave but with no luck.\nYou lost! You got the"+YELLOW+" F-STUDENT ending!");
                System.exit(0);
            }
        }
        else if(hasPaper==true && hasRing==false && inWaterCave==false){
            System.out.println("---");
            System.out.println(RED+"You try to backtrack and follow the footsteps"+RESET+", but they lead no where\nWith no option, you venture down the cave... alone...\nAfter some time, you find what seems to be a village inhabited by orcs.\nSuddenly an orc appears, but it doesn't attack you.\nHe grabs you and takes you to a large building. It seems to be a townhall.\nYou're greeted by a giant armored goblin.\n");
            Thread.sleep(4000);
            System.out.println("The orc questions you and, you explain your situation.\nThey notice the paper you have and "+RED+"they're more than willing to help you find a way out the cave!"+RESET);
            orcsFriendly=true;
        }
        //DECISION 5 - STEAL OR DON'T STEAL
        //Note that orcs Friendly will only ever be true if they have gone through path shown above
        if (orcsFriendly){
            System.out.println("---");
            System.out.println("They let you "+RED+"venture the village "+RESET+"as they prepare their team, it's dead silent and no one is around.\nYou notice that their treasurey containing pure gold coins is in the open.\nWhat do you do?");
            System.out.println("(1) Steal a couple coins. ");
            System.out.println("(2) Don't steal\n");
            System.out.print(">");
            playerSelection = input.nextInt();
            //GREEDY ENDING
            if(playerSelection==1){
                System.out.println("---");
                System.out.println("You "+RED+"nab a couple coins"+RESET+" and hide them in your pockets.\nThe team of orcs return and they instantly notice the large coin-like outline in your pocket.\nThey forcibly empty your pockets, finding the pieces of gold you stole.\nBecause of your actions, they slice your head off.\n\nYou die! You got the"+YELLOW+" GREEDY ending!");
                System.exit(0);
            }//IDEAL ENDING
            else if (playerSelection==2){
                System.out.println("---");
                System.out.println("You wait patiently, eyeing the gold, but "+RED+"resisting the urge to steal"+RESET+".\nThe orcs come back and lead you to a large door.\nUsing your paper they wave it at the door and cast a spell, opening the door!");
                System.out.println("\nYou escaped! "+YELLOW+"You got the IDEAL ending!");
                System.exit(0);
            }
        }
        //This is only available if you travelled right, after you "climbed out of the water"
        if (inWaterCave==true){
            //DECISION 5(if you threw out ring), DECISION 4 if you just left the water
            System.out.println( RED+"The orc is long gone"+RESET+" and now you're wet and alone in the cave. Cold and hopeless, you feel theres only two options:\n");
            System.out.println("(1) Cry out for help ");
            System.out.println("(2) Stay quiet and wait\n");
            System.out.print(">");
            playerSelection = input.nextInt();
            //cry out for help
            if(playerSelection==1){
                System.out.println("---");
                //Decision 5 - pull knife or attempt to communicate
                System.out.println("You "+RED+"cry out for help"+RESET+", praying that someone responds\nSomething does respond.\nIt's an orc.\nThe orc doesn't look mean, but it doesn't necessarily look kind. What do you do?\n");
                System.out.println("(1) Pull out your knife ");
                System.out.println("(2) Attempt to communicate\n");
                System.out.print(">");
                playerSelection = input.nextInt();
                //DESPERATE ENDING
                if(playerSelection==1){
                    System.out.println("---");
                    System.out.println("You jump the gun, "+RED+"wielding your knife with your shaky cold hands"+RESET+".\nThe orc large arms tighten, and he begins to charge you\nYou're knocked to the ground and beat to a pulp.\n\nYou died! You got the "+YELLOW+"DESPERATE ending!");
                    System.exit(0);
                }//PIGGY BACK ENDING
                else if(playerSelection==2){
                    System.out.println("---");
                    System.out.println(RED+"You try to speak"+RESET+", but the orc silently analyzes your face with a curiousity.\nSuddenly, he picks you up and places you on it's back.\nIt sprints down the cave as you are jostled on its back.\n");
                    Thread.sleep(3000);
                    System.out.println("The orc placed you down gently and you are greeted by a man.\nThe man introduces himself as an orc scientist.\nYou explain your situation and the Orc Scientist leads you to a stone wall.\n");
                    Thread.sleep(3000);
                    System.out.println("He waves a piece of paper around whilst chanting Latin. The walls split and daylight lays ahead.\n\nYou escaped! You got the "+YELLOW+"PIGGYBACK ending!");
                    System.exit(0);
                }
            }//DECISION 4
                System.out.println("---");
                System.out.println("You "+RED+"patiently wait out of sight"+RESET+", listening to the dripping water.");
                Thread.sleep(3000);
                System.out.println("After some time, a group of three orcs walk by.\nNotably, you notice that one has a map.\nYou're scared, but you know your options are scarce.What do you do?");
                System.out.println("(1) Attempt to negotiate");
                System.out.println("(2) Attempt to steal map\n");
                System.out.print(">");
                playerSelection = input.nextInt();
                if(playerSelection==1){
                    System.out.println("---");
                    System.out.println("You approach the orcs slowly, trying not to provoke them.\nYou point at their map and do your best to convey that you want to negotiate for it.\nLuckily, they seem to understand and "+RED+"are willing to trade..."+RESET+"\nFor your shirt, your waterbottle, your pocket knife, and your lighter.\nIt seems almost like a sick prank\nWhat do you do?\n");
                    System.out.println("(1) Give them everything");
                    System.out.println("(2) Try to lowball\n");
                    System.out.print(">");
                    playerSelection = input.nextInt();
                    //NEGOTIATOR ENDING
                    if(playerSelection==1){
                        System.out.println("---");
                        System.out.println("They "+RED+"happily take your belongings"+RESET+", and instead of killing you, they lead you to a secret tunnel hidden behind a stalagmite.\nThey usher you in. A ladder is visible at the end of the tunnel!\nYou climb out of the cave!\n\nYou escaped! You got the NEGOTIATOR ending");
                        System.exit(0);
                    }
                    //CHEAPSKATE ENDING
                    else if(playerSelection==2){
                        System.out.println("---");
                        System.out.println("\nYou keep your shirt on and "+RED+"give them only your lighter."+RESET+"\nTheir neutral face suddenly turned aggressive.\nThey saw through your attempt to lowball!\nThey club your head in with bone clubs.\n\nYou died! You got the CHEAPSKATE ending");
                        System.exit(0);
                    }
                }
                //SNEAK 0 ENDING
                else if(playerSelection==2){
                    System.out.println("---");
                    System.out.println("You "+RED+"attempt to sneak"+RESET+" behind the three orcs, but your wet shoes make squidward-like noises as you approach.\nThe orcs turn around and can tell you're up to no good.\nThey crush your skull.\n\nYou died! You got the "+YELLOW+"SNEAK 0 ending!");
                    System.exit(0);
                }
        }
    }
    
}
