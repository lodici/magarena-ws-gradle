package magic.test;

import magic.model.MagicDeckProfile;
import magic.model.MagicDuel;
import magic.model.MagicGame;
import magic.model.MagicPlayer;
import magic.model.MagicPlayerDefinition;
import magic.model.phase.MagicEndOfTurnPhase;

class TestSearch extends TestGameBuilder {
    public MagicGame getGame() {
        final MagicDuel duel=new MagicDuel();
        duel.setDifficulty(6);

        final MagicDeckProfile profile=new MagicDeckProfile("bgruw");
        final MagicPlayerDefinition player1=new MagicPlayerDefinition("Player",false,profile);
        final MagicPlayerDefinition player2=new MagicPlayerDefinition("Computer",true,profile);
        duel.setPlayers(new MagicPlayerDefinition[]{player1,player2});
        duel.setStartPlayer(1);

        final MagicGame game=duel.nextGame();
        game.setPhase(MagicEndOfTurnPhase.getInstance());
        final MagicPlayer player=game.getPlayer(0);
        final MagicPlayer opponent=game.getPlayer(1);

        MagicPlayer P = player;

        P.setLife(6);

        addToLibrary(P, "Bayou", 1);
        addToLibrary(P, "Badlands", 1);
        addToLibrary(P, "Goblin King", 4);
        addToLibrary(P, "Forest", 20);
        addToLibrary(P, "Island", 20);
        createPermanent(game,P,"Rupture Spire",false,9);
        createPermanent(game,P, "Grizzly Bears", false, 2);
        addToHand(P, "Misty Rainforest", 1);
        addToHand(P, "Terramorphic Expanse", 1);
        addToHand(P, "Rampant Growth", 1);
        addToHand(P, "Farseek", 1);
        addToHand(P, "Verdant Catacombs", 1);
        addToHand(P, "Sylvan Scrying", 2);
        addToHand(P, "Perilous Forays", 1);
        addToHand(P, "Primeval Titan", 1);
        addToHand(P,"Altar of Bone",1);
        addToHand(P, "Goblin Matron", 1);

        P = opponent;

        P.setLife(6);
        addToLibrary(P, "Mountain", 20);
        createPermanent(game,P,"Rupture Spire",false,9);
        createPermanent(game,P, "Grizzly Bears", false, 1);
        addToGraveyard(P, "Ink-Eyes, Servant of Oni", 1);

        return game;
    }
}
