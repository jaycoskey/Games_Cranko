
Cranko is an idea for a game playing system that will support multiple games through a flexible domain-specific language (DSL). It focuses on the ability to support modification of the game's core rules through (a) cards with specific moves or rules, and (b) "deals" or "contracts" made between players.

== Motivating Examples ==
* In the game Monopoly, cards drawn from the Chance and Community Chest piles describe actions that modify game state. The book Beyond Boardwalk and Park Place (by Noel Gunther, 1986) proposes additional cards that attmept to improve the game.
  - In Cranko, such additional cards will be added through a configuration change.
* Also in Monopoly, players often make deals (i.e., contracts) that involve exchanging property and money, but are sometimes more elaborate, with deals involving limited immunity to future requirements to pay rent, pre-agreements to later trades once specific property is owned, etc.
  - In Cranko, players will formulate and agree to executable contracts in game's DSL that will modify subsequent gameplay.
  - Any DSL sophisticated enough to support such deals/contracts between players will also be able to support Monopoly's Mortgate and Auction features.
* There is a game called Knightmare Chess (by Steve Jackson, 1996) that extends a game of chess by having each card modify the rules of a chess game. There have been three releases of Knightmare Chess (1st ed. (1996), 2nd ed. (1997), and Knightmare Chess 2 (1997)).
  - In Cranko, changing the cards used in such a game will be done through a configuration change, rather than requiring changes to the core game itself.
* Magic: The Gathering is a card game that has released several new cards.
  - In Cranko, supporting different sets of cards will only require a change in configuration.
* Nomic is a game created in 1982 by philosopher Peter Suber. The rules of the game includes the players collectively changing the rules of the game, including the conditions for winning.
* Fluxx is a card game created in 1996 by Andrew Looney. The cards played change the rules and the conditions for winning.

Contracts could be applied to software implementations of a wide variety of games, but they will make sense for some games more than others.

One of the goals of Cranko will be to, at some point, support AI computer players. Making this computationally feasible while supporting the proposal and acceptance of arbitrarily complex contracts between players will require judicious limits on searches of game trees, and a heuristic for evaluating the value of such contracts.

== Origin of the name ==
The term "Cranko" comes from season 6, episode 18 ("Your Hit Parade") of the TV show M\*A\*S\*H. In the first scene, characters Hawkeye and B.J. are playing a rules-free game called Double Cranko that combines elements of chess, checkers, and poker. In the final scene, Hawkeye suggests that Colonel Potter is ready to play Triple Cranko. (The second choice name was "Ludus Ponens".)

In the early days of the World Wide Web, I considered claiming the cranko.\* domains, but never did. It appears that doublecranko.com and triplecranko.com are still available!

== Motivating Examples Recap ==

* [Monopoly](<https://en.wikipedia.org/wiki/Monopoly_(game)>) - A classic, with many variants (e.g., the Landlord's game, Triopoly, Anti-Monopoly, etc.).
* [Knightmare Chess](https://en.wikipedia.org/wiki/Knightmare_Chess) - Cards that modify the rules of chess.
* [Magic: The Gathering](https://en.wikipedia.org/wiki/Magic:_The_Gathering) - Classic collectible card game.
* [Nomic](https://en.wikipedia.org/wiki/Nomic) - The players collectively modify the rules of the game.
* [FLuxx](https://en.wikipedia.org/wiki/Fluxx) - Cards played change the rules of the game.

There are likely many other resources that have originated from online implementations of Magic: The Gathering, or rleated collectible card games.

== Contract Details ==
In addition to standard game types (Player, Piece, Board, Card, Dice, Move, Turn, etc.) and utility classes, Cranko will have classes to support rule modifications that will arise in the context of rule-modifying cards and contracts between players. The following gives a sense of what these might look like.
* Ability         // "can".
* Attribute       // E.g., damage or fuel, to add limited resource management to enrich gameplay.
* Authorization   // Offered and accepted contracts act with the authority of its accepting parties.
* Contract        // Jurisdiction. Offer and acceptance. Transferability. Cards implemented via Contract. Breach.
* ContractClause  // Trigger and outcome. Require and ensure for design by contract.
* Law             // Settings that determine what elements of Contracts are or are not allowed.
* Obligation      // "must". If not automatically enforced, then a Player can become in breach of contract.
* Organization    // Players can form Organizations that combine some aspects of more than one Player to form a new Agent.
* Rule            // Standard game rules, but encapsulated into granular, referenceable elements to facilitate variations and modifications.
* Time            // Note: The notion of time will include not only Turns and Moves, but also  possibly Phases, Segments, etc.
* Transfer        // Base action for transfer ownership of tokens, money, etc.

== Possible Milestones ==
* DSL issues
    - Language family/paradigm decisions
        - Type system (strong & static? higher-order types?)
        - Evaluation strategy
        - Polymorphism strategy
    - Use S-expressions as a starting point. Syntax innovation is not a primary goal.
        - Compare with Clojure. (E.g.: Quoting to suspend evaluation? Higher order function?)
        - Add additional syntax when the DSL complexity makes the DSL more expressive, clear, or concise.
            - E.g., add arg_name=... to specify argument names, or foo:type to specify types.
        - Add identifiers as needed to reference fine-grained rules.
    - Arithmetic expression lexer/tokenizer: S-expressions only
    - Arithmetic expression parser: S-expressions only
    - Ability to express rules of simple game, with pieces moving around board
        - Rules to be fine-grained and referenceable to support overrides
    - Resources (e.g., money, property) to provide an incentive for contracts
    - Composability
* Software engineering
    - SCM:     Github
    - Testing: JUnit
    - Build:   Maven
    - CI/CD:   Travis
* Game basics
    - Move pieces around board
    - Make purchases with money
    - Fine-grained game context, used to reference and modify rules
* Contracs
    - Offer & acceptance of contracts
    - Purchases (simple, immediate exchange of money for another resource, on a single host)
        - Offer, offer expiration, and acceptance
        - Timing
            - Initially, offers can only be made during the offering player's turn.
    - Auction
    - For single-party contracts (e.g., rules or cards)
        - Lasting effect
        - Trigger conditions (from context)
        - Terminating conditions (from context)
        - Application / termination at time of player choice
    - Multi-party contracts
    - Contract value heuristics. (E.g., NPV of est. frequency of benefit * value)
        - Possibly restrict valid contracts to those that can have their value estimated via heuristics.
    - Handling breach of contract situations
* GUI
    - Show game state and player options, with means of selecting chosen option
        - Interface for contracts: Text-based vs GUI
    - Show game history. Support Undo, Rewind, etc.
* Networking
    - Serialization
    - Networking
* AI
    - Requires heuristics for evaluation of contract value
    - Strategies: Random, Alpha-beta pruning, MCTS, Deep Reinforcement Learning, etc.

== Related Software Projects ==
* [Ludi](http://cambolbro.com/cv/publications/ciaig-browne-maire-19.pdf), by Cameron Browne - A system to facilitate evolutionary searches for new high-quality games. This resulted in the invention of the game Yavalath, among others.
* [Ludii](https://ludii.games/), by Cameron Browne (2019) - A successor to Ludi, this general game system is a cornerstone of the [Digital Ludeme Project](http://ludeme.eu/index.html), sponsored by the European Research Council (ERC).
* [Zillions of Games](https://en.wikipedia.org/wiki/Zillions_of_Games) is a commercial general game playing system released for the PC by Jeff Mallett and Mark Lefler in 1998. It ships with over 300 games and puzzles, and allows users to define and play their own games stored in so-called ZRF (zillions rules file) files.

== Other Resources ==
* Books:
  - Beyond Boardwalk and Park Place, by Noel Gunther, 1986.
  - Characteristics of Games, by George Skaff Elias, Richard Garfield, Robert Gutschera, 2012.

* Software:
  - Microsoft .NET's System.Linq.Expressions namespace, which supports building expression trees.

* XML standards
  - RuleML
  - LegalRuleML
