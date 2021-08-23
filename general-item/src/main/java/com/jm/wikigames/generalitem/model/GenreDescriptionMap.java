package com.jm.wikigames.generalitem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class GenreDescriptionMap {
    private Map<String, String> genreDescription = new HashMap<>();

    {


        // main genres


        genreDescription.put("Action games", "Action games are just that—games where the player is in control of " +
                "and at the center of the action, which is mainly comprised of physical challenges players must overcome. " +
                "Most early video games like Donkey Kong and Galaga fall into the action category.\n" +
                "\n" +
                "Because action games are usually easy to get into and start playing, they still, by most accounts, " +
                "make up the most popular video games.\n" +
                "\n" +
                "Action subgenres:\n" +
                "Platformer\n" +
                "Shooter\n" +
                "Fighting\n" +
                "Beat-em up\n" +
                "Stealth\n" +
                "Survival\n" +
                "Rhythm\n");
        genreDescription.put("Action-adventure games", "Action-adventure games most frequently incorporate " +
                "two game mechanics—game-long quests or obstacles that must be conquered using a tool or item collected, " +
                "as well as an action element where the item(s) are used.\n" +
                "\n" +
                "For example, in The Legend of Zelda, Link must find his way through eight dungeons " +
                "to gather the scattered pieces of the Triforce of Wisdom. Once he’s collected all eight pieces and assembled the artifact, " +
                "Link can enter the ninth and final dungeon to rescue Princess Zelda. " +
                "Link uses a boomerang to collect distant items and attack enemies.\n" +
                "\n" +
                "Action-adventure games like The Legend of Zelda focus more on exploration, solving puzzles, and discovering loot, " +
                "while basic combat is more of a supporting activity to the overall experience.\n" +
                "Action-Adventure subgenres:\n" +
                "Survival horror\n" +
                "Metroidvania\n");
        genreDescription.put("Adventure games", "Adventure games are categorized by the style of gameplay, " +
                "not the story or content. And while technology has given developers new options to explore storytelling in the genre, " +
                "at a basic level, adventure games haven’t evolved much from their text-based origins.\n" +
                "\n" +
                "In adventure games, players usually interact with their environment and other characters to solve puzzles " +
                "with clues to progress the story or gameplay. Aside from an occasional mini-game, " +
                "adventure games rarely involve any traditional video game action elements. " +
                "Thus, the genre isn’t very popular with mainstream gamers." +
                "Adventure subgenres:\n" +
                "Text adventures\n" +
                "Graphic adventures\n" +
                "Visual novels\n" +
                "Interactive movie\n" +
                "Real-time 3D\n");
        genreDescription.put("Role-playing games", "Probably the second-most popular game genre, role-playing games, " +
                "or RPGs, mostly feature medieval or fantasy settings. This is due mainly to the origin of the genre, " +
                "which can be traced back to Dungeons & Dragons and other pen and paper role-playing games. " +
                "Still, hardcore RPGers don’t discount sci-fi fantasy-themed RPGs like Mass Effect, Fallout, " +
                "and Final Fantasy, which have helped put unique spins on the genre.\n" +
                "\n" +
                "Cultural differences have also had a bearing on this genre, as many gamers categorize RPGs as " +
                "either WRPGs (Western-influenced) or JPRGs (Japanese-influenced). Finally, " +
                "gamers are often given choices in this genre that influence the final outcome of the game, " +
                "which means many RPGs have alternate endings." +
                "Role-playing games subgenres:\n" +
                "Action RPG\n" +
                "MMORPG\n" +
                "Rouguelikes\n" +
                "Tactical RPG\n" +
                "Sandbox RPG\n" +
                "First-person party-based RPG\n");
        genreDescription.put("Simulation games", "Games in the simulation genre have one thing in common — " +
                "they're all designed to emulate real or fictional reality, to simulate a real situation or event." +
                "Simulation games subgenres:\n" +
                "Construction and management simulation\n" +
                "Life simulation\n" +
                "Vehicle simulation\n");
        genreDescription.put("Strategy games", "With gameplay is based on traditional strategy board games, " +
                "strategy games give players a godlike access to the world and its resources. " +
                "These games require players to use carefully developed strategy and tactics to overcome challenges. " +
                "More recently, these type of games have moved from turn-based systems to real-time gameplay in response to player feedback." +
                "Strategy games subgenres:\n" +
                "4X\n" +
                "Artillery\n" +
                "Real-time strategy (RTS)\n" +
                "Real-time tactics (RTT)\n" +
                "Multiplayer online battle arena (MOBA)\n" +
                "Tower defense\n" +
                "Turn-based strategy (TBS)\n" +
                "Turn-based tactics (TBT)\n" +
                "Wargame\n" +
                "Grand strategy wargame\n");
        genreDescription.put("Sports games", "Sports games simulate sports like golf, football, basketball, baseball, and soccer. " +
                "They can also include Olympic sports like skiing, and even pub sports like darts and pool. " +
                "Opposing players in these games are often computer-controlled but can also take the form of live opponents. " +
                "(And since we are on the topic of sports, video games should be considered sports themselves!) " +
                "Sports games subgenres:\n" +
                "Racing\n" +
                "Team sports\n" +
                "Competitive\n" +
                "Sports-based fighting\n");
        genreDescription.put("Puzzle games", "Puzzle or logic games usually take place on a single screen or " +
                "playfield and require the player to solve a problem to advance the action." +
                "Puzzle games subgenres:\n" +
                "Logic game\n" +
                "Trivia game\n");
        genreDescription.put("Idle games", "As technology continues to push the confines of what’s possible in video gaming — " +
                "and as players and developers push the confines of game genres—new genres are created all the time." +
                "Idle games subgenres:\n" +
                "Idle gaming\n" +
                "Casual game\n" +
                "Party game\n" +
                "Programming game\n" +
                "Board game/card game\n" +
                "Massive multiplayer online (MMO)\n" +
                "Advergame\n" +
                "Art game\n" +
                "Educational game\n" +
                "Exergame\n");


        // Subgenres


        // Action subgenres


        genreDescription.put("Platformer", "Platformer games get their name from the fact that the game’s character interacts with platforms " +
                "(usually running, jumping, or falling) throughout the gameplay. There are many types of platform games; " +
                "Super Mario Bros. is probably the best known, and Donkey Kong was one of the earliest.");
        genreDescription.put("Shooter", "Shooters let players use weapons to engage in the action, with the goal usually being to take out enemies or opposing players.\n" +
                "\n" +
                "Shooters are categorized by the player perspective:\n" +
                "\n" +
                "First-person shooters (FPS) are played from the main character’s viewpoint; Call of Duty, Half-Life, and Halo are good examples.\n" +
                "\n" +
                "With third-person shooters like Fortnite and Splatoon, the action takes place from a viewpoint " +
                "where the player can see the main character, usually from slightly above and behind.\n" +
                "\n" +
                "Top-down shooters, like Galaga, Space Invaders, and Raiden V: Director’s Cut feature a complete overhead experience. " +
                "Where third-person shooters might usually display health bars or meters that get worse or better depending on " +
                "the character's health or condition, top-down shooters are typically based on sets of lives, " +
                "with players reaching a \"game over\" when that stash of lives runs out.");
        genreDescription.put("Fighting", "Fighting games like Mortal Kombat and Street Fighter II focus the action on combat, " +
                "and in most cases, hand-to-hand combat. Most fighting games feature a stable of playable characters, " +
                "each one specializing in their own unique abilities or fighting style. In most traditional fighting games, " +
                "players fight their way to the top, taking on more and more difficult opponents as they progress.");
        genreDescription.put("Beat-em up", "Beat-em up games, or brawlers, also focus on combat, " +
                "but instead of facing a single opponent, players face wave after wave of enemies. " +
                "Double Dragon was one of the earliest beat-em ups, while God of War, Castle Crashers, and Bayonetta are more recent ones.");
        genreDescription.put("Stealth", "Stealth games stress cunning and precision to resolve game challenges, " +
                "and while other action or combat may help players accomplish the goal, like in Dishonored, " +
                "stealth games usually encourage players to engage in the action covertly. Metal Gear built a franchise name on this subcategory.");
        genreDescription.put("Survival", "A subgenre of action games, " +
                "survival action games have really come into their own over the past few years. " +
                "The survival horror game Resident Evil was one of the earliest (though a linear game), " +
                "while more modern survival games like Fortnite take place in open-world game environments and " +
                "give players access to resources to craft tools, weapons, and shelter to survive as long as possible.");
        genreDescription.put("Rhythm", "Rhythm games like Dance Dance Revolution and Guitar Hero are music-based games " +
                "that challenge players to keep in step with the rhythm of a song or soundtrack in the game by pressing " +
                "a corresponding button on the controller at a precise time to accumulate points.");


        // Action-adventure subgenres


        genreDescription.put("Survival horror", "Survival horror games like Resident Evil use mature themes and " +
                "subject matter to portray grisly and gruesome settings (many of these games use blood and gore " +
                "and are intended only for mature audiences). Such titles deliver nail-biting excitement amplified by a key game mechanic: " +
                "limited resources like ammunition or finite weapons.");
        genreDescription.put("Metroidvania", "The game genre whose name is based on the games that inspired it, " +
                "Metroid and Castlevania. Metroidvania-type games are like basic action-adventure games, but aren't linear, " +
                "and often require that the player backtrack, or is kept from progressing, until they find a specific item or special tool. " +
                "“Upgrading” your character with new weapons, abilities, and other power-ups allows them to " +
                "access “special”  areas of the game—but not before a bossfight, which is also a major characteristic of Metroidvania-type games.");


        // Adventure subgenres


        genreDescription.put("Text adventures", "Early text adventure games were called \"interactive fiction.\" " +
                "And just as the name implies, the gameplay is text-based, meaning players use their keyboard to " +
                "input commands in response to the game-programmed story arch or situation, such as “get shovel,” " +
                "“grab sword,” or “go North.” With text adventures, " +
                "programmers spend quite a bit of development time working out various responses to the players’ inputs.");
        genreDescription.put("Graphic adventures", "As computers became more capable of creating graphics to support text, " +
                "games evolved as well. For instance, early graphic adventure games used simple images to support the still text-based adventure. " +
                "Later, as the mouse evolved into a game controller, games started to replace written text commands, " +
                "and players began to “point-and-click” to interact with an on-screen object.");
        genreDescription.put("Visual novels", "Extremely popular in Japan, " +
                "most visual novels require players to build up character traits or statistics to advance the gameplay. " +
                "The games often have multiple endings which are determined by how the player responds to specific points in the plot. " +
                "Dating and legal simulations (Ace Attorney for the Nintendo DS, for example) are popular themes for many visual novels.");
        genreDescription.put("Interactive movie", "Laserdisc and CD-ROM technology allowed for the introduction of the interactive movie. " +
                "Interactive movies contain pre-filmed live-action or animation sequences. " +
                "The adventure is played out typically from a third-person perspective and the player controls the action during pivotal points in the story, " +
                "like pushing a joystick right or pressing a button to “jump” out of the way as a boulder rushes toward them.");
        genreDescription.put("Real-time 3D", "The latest evolution of adventure games is real-time 3D. " +
                "Instead of pre-rendered scenes, players interact in a real-time 3D video game world. " +
                "Shenmue and Heavy Rain are good examples of these types of games.");


        // Role-Playing Games subgenres


        genreDescription.put("Action RPG", "Action role-playing games take game elements of both action games and action-adventure games. " +
                "A defining characteristic of action RPGs is that the combat takes place in real-time and " +
                "depends on a player’s speed and accuracy to best foes, versus depending on high character attributes like charisma and dexterity.");
        genreDescription.put("MMORPG", "Massive multiplayer online role-playing games (or MMORPGs) evolved as graphical variations of text-based multi-user dungeons (MUDs), which were developed in the late 1970s.\n" +
                "\n" +
                "MMORPGs involve hundreds of players actively interacting with each other in the same world, and typically, " +
                "all players share the same or a similar objective.");
        genreDescription.put("Rouguelikes", "The only other game genre based on the name of the game that inspired it, " +
                "Rogue was a 2D computer game and dungeon crawler from 1980. " +
                "The game featured a text interface and random level generation. " +
                "Players overcame enemies and obstacles to increase their player stats.");
        genreDescription.put("Tactical RPG", "Considering their origins in tabletop gaming, " +
                "tactical role-playing games play more like traditional board games, wherein the turn-based game action " +
                "plays out over an isometric grid. Players use almost chess-like strategy and a finite numbers of resources " +
                "(armies, weapons, etc.) to conquer battles and enemies.");
        genreDescription.put("Sandbox RPG", "Sandbox, or open-world, role-playing games allow players to freely roam their " +
                "game environments in search of adventure. These are some of the most immersive and engaging video game experiences " +
                "available, because the massive amount of game characters and situations required to " +
                "populate side quests and supporting storylines enable game developers to create almost lifelike virtual worlds.");
        genreDescription.put("First-person party-based RPG", "“Blobbers” as they’re known to hardcore gamers, " +
                "are dungeon role-playing games (dungeon RPGs) where a player leads a party of adventurers in first-person perspective. " +
                "Games like Might and Magic and Bard’s Tale fall into this category " +
                "because the player moves the entire party as a single unit or “blob” around the gaming area. " +
                "Most “blobbers” are turn-based but some games can be played in real time.");


        // Simulation Games subgenres


        genreDescription.put("Construction and management simulation", "SimCity is the most popular construction and management simulation of all time. " +
                "The game simulates the building and management of a city, including street planning, zoning, and taxing city residents.");
        genreDescription.put("Life simulation", "The Sims is the most popular life simulation game and one of the best-selling " +
                "video games of all time. Like SimCity (which was also created by Will Wright), in The Sims, " +
                "players control the individual aspects of artificial life. Simulations may allow players to " +
                "manipulate a character’s genetics or their ecosystem. Even the character’s reaction to a certain situation " +
                "may be under the player’s control.\n" +
                "\n" +
                "Virtual pet games like Nintendogs and Tamagotchi are considered part of the subgenre of this category as " +
                "pet-raising simulations. Thus, The Sims is considered a social simulation. " +
                "Both types of subgenres fall into the life simulation category.\n" +
                "\n" +
                "Finally, because of the control these games give to players over the characters and their surroundings, " +
                "life simulations are sometimes called “god games.”");
        genreDescription.put("Vehicle simulation", "It’s difficult to rank the most popular vehicle simulation games because " +
                "sales are equally split between flight simulations and racing simulations. " +
                "Vehicle simulations aim to recreate the experience of flying an airplane, " +
                "driving a race car, and in some cases, driving a tractor on a farm.\n" +
                "\n" +
                "Vehicular simulations can incorporate combat, in the case of flight sims. " +
                "This category includes space flight simulators and train simulators.");

        // Strategy Games subgenres


        genreDescription.put("4X", "A 4x is any genre of strategy video game whose four primary goals check these boxes: " +
                "explore, expand, exploit, and exterminate. Sid Meier’s Civilization series is probably " +
                "the best-known strategy game in this category. Because of the underlying goals, " +
                "most of these games have historical settings and span eons of a civilization’s (human or extraterrestrial) history.");
        genreDescription.put("Artillery", "A general name given to two- or three-player turn-based games featuring tanks or other soldiers engaged in combat.");
        genreDescription.put("Real-time strategy (RTS)", "Real-time strategy games require the player to collect and maintain resources, " +
                "like bases, while advancing and developing both resources and combat units. " +
                "Starcraft is the most popular RTS, while The Age of Empires series and Command and Conquer are " +
                "also well-known game franchises in this category.");
        genreDescription.put("Real-time tactics (RTT)", "Sometimes considered a subgenre of real-time strategy, " +
                "real-time tactics games focus on battlefield tactics and operational warfare versus the micromanagement of resources or individual units.");
        genreDescription.put("Multiplayer online battle arena (MOBA)", "This category combines action games, " +
                "role-playing games, and real-time strategy games. In this subgenre of strategy games, " +
                "players usually don't build resources such as bases or combat units. Instead, " +
                "players control a single character in one of two teams, working together to try and destroy the other team’s base " +
                "(they are often aided in the task by the help of computer-controlled units that attack on a set path).");
        genreDescription.put("Tower defense", "In tower defense games, players must fend off computer-controlled enemies " +
                "(often referred to as “creeps”) to win. Tower abilities and creep movements vary from game to game, " +
                "but usually tower defense games give different towers different abilities, " +
                "such as the ability to slow down creeps or poison them. When a player kills enough creeps, " +
                "they're awarded credits to purchase more towers or buy upgrades to increase something like weapon power or range.");
        genreDescription.put("Turn-based strategy (TBS)", "This category is used to differentiate turn-based strategy games " +
                "from real-time strategy ones. A turn-based strategy game gives players a length of time (or turn) in which to take action.  " +
                "But like an RTS game, the genre can include games that are not exclusively turn-based.\n" +
                "\n" +
                "Another subgenre is developing from this category: simultaneous turn-based strategy (STBS) games are " +
                "just that—games that let players and opponents interrupt actions and change the gameplay, simultaneously.");
        genreDescription.put("Turn-based tactics (TBT)", "Based on and mostly using realistic military tactics, " +
                "turn-based tactics games pit combat forces against each other in volley-like gameplay. " +
                "Fire Emblem and Final Fantasy Tactics are two of the more well-known games in this category.");
        genreDescription.put("Wargame", "A subgenre of strategy video games, " +
                "a wargame focuses gameplay on map-based tactical or strategic warfare. " +
                "Games like Real War can be played out as turn-based events or in real-time.");
        genreDescription.put("Grand strategy wargame", "This is a wargame that focuses on a grand strategy, " +
                "which typically involves placing a nation or empire’s army and resources into action to achieve a goal.");


        // Sports Games subgenres


        genreDescription.put("Racing", "Racing simulator series like Forza and Gran Turismo are " +
                "some of the most popular games in this category, but arcade classics like Pole Position are included here too. " +
                "In these games, players race against another opponent or the clock.");
        genreDescription.put("Team sports", "One of the earliest types of video games genres, team sports games simulate playing a sport. " +
                "Some games, like Arch Rivals and NBA Jam, satirize the genre, while others " +
                "like Madden NFL and FIFA look to recreate the realism and capture the feeling of playing a live sport.");
        genreDescription.put("Competitive", "Fictional sport or competitive games fall into this category. " +
                "eSport games like Overwatch and Team Fortress have also been assigned to this subgenre.");
        genreDescription.put("Sports-based fighting", "Rooted firmly in the fighting game and sports genre, " +
                "these games include boxing games like Fight Night and wrestling video games. " +
                "In these games, the fighting is more realistic and can feature real-world fighters.");


        // Puzzle Games subgenres
        genreDescription.put("Logic game", "A logic game requires players to solve a logic puzzle or navigate a challenge like a maze. " +
                "These games include brain games like Brain Age, but also include such casual puzzle games as Tetris.");
        genreDescription.put("Trivia game", "Like real trivia games, video trivia game players must answer a question before " +
                "a timer runs out (or before another player answers) to score points. " +
                "Since trivia games are especially well suited to casual play, they are increasingly growing in popularity, especially on mobile phones.");


        // Idle Games subgenres


        genreDescription.put("Idle gaming", "Not to be confused with casual gaming, idle games are simplified games that " +
                "involve minimal player involvement, such as clicking on an icon over and over. " +
                "Idle games keep players engaged by rewarding those who complete simple objectives.");
        genreDescription.put("Casual game", "Casual games exhibit basic game mechanics and are perfect for short, casual sessions.  " +
                "This genre has exploded in popularity in the last few years thanks to mobile gaming. " +
                "Developers often use rewards and carefully designed levels to keep players striving to get further, " +
                "because gameplay in this genre is usually quite repetitive.");
        genreDescription.put("Party game", "Designed for multiple (four or more) players, " +
                "party games like Mario Party usually feature mini game competitions with participants " +
                "competing against each other to finish a challenge before other players.");
        genreDescription.put("Programming game", "A programming game usually has players using code to complete a challenge or " +
                "overcome an obstacle. Codehunt for example, is a game played using either Java or C# " +
                "where players write code to learn computer languages and programming elements like loops, strings, and ciphers. " +
                "(Learn more about coding apps with Java or C++.)");
        genreDescription.put("Board game/card game", "Traditional games like chess, checkers, " +
                "and backgammon are still popular the world over, and as the world becomes increasingly digital, " +
                "so do those traditional games. Card games like Magic: The Gathering and the Pokémon Card Game are at home here too.");
        genreDescription.put("Massive multiplayer online (MMO)", "These games are played almost exclusively on the internet or " +
                "network-enabled platforms. MMOs also include a variety of game modes, where players can cooperate or " +
                "compete against one another. Minecraft, for example, can be played both as a single-player game experience or as an MMO.");
        genreDescription.put("Advergame", "Advergames are typically created to help sell a product or brand, " +
                "with the brand or advertiser directing the game developer to create an interactive experience based around a product.");
        genreDescription.put("Art game", "An art game showcases art or a structure, and like art, is meant to incite an emotional feeling with its audience. " +
                "Typically these games don’t feature gameplay but instead are more like “interactive experiences.”");
        genreDescription.put("Educational game", "Used mainly as a learning tool, " +
                "educational games are used to teach subjects like math or typing using basic game mechanics, " +
                "and thus stand out on most lists of best video games for kids. Don't be fooled, though, " +
                "(and not to confuse) but technically non-educational games like Minecraft can be educational as well.");
        genreDescription.put("Exergame", "The bane of the video game world, " +
                "exergames are specifically designed to work with a peripheral or controller that allows the player to " +
                "simulate an exercise or activity. Games like Wii Fit track the number of repetitions and user progress much like a fitness watch.");
    }
}