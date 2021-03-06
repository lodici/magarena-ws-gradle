package magic.test;

import magic.model.MagicDeckProfile;
import magic.model.MagicDuel;
import magic.model.MagicGame;
import magic.model.MagicPlayer;
import magic.model.MagicPlayerDefinition;
import magic.model.phase.MagicMainPhase;

class TestGainControl extends TestGameBuilder {
    public MagicGame getGame() {
        final MagicDuel duel=new MagicDuel();
        duel.setDifficulty(6);

        final MagicDeckProfile profile=new MagicDeckProfile("bgruw");
        final MagicPlayerDefinition player1=new MagicPlayerDefinition("Player",false,profile);
        final MagicPlayerDefinition player2=new MagicPlayerDefinition("Computer",true,profile);
        duel.setPlayers(new MagicPlayerDefinition[]{player1,player2});
        duel.setStartPlayer(0);

        final MagicGame game=duel.nextGame();
        game.setPhase(MagicMainPhase.getFirstInstance());
        final MagicPlayer player=game.getPlayer(0);
        final MagicPlayer opponent=game.getPlayer(1);

        MagicPlayer P = player;

        P.setLife(20);
        addToLibrary(P, "Plains", 10);
        createPermanent(game,P,"Rupture Spire",false,8);
        createPermanent(game,P,"Creeping Tar Pit",false,1);
        createPermanent(game,P,"Raging Ravine",false,1);
        createPermanent(game,P,"Memnarch",false,1);
        createPermanent(game,P,"Grizzly Bears",false,3);
        addToHand(P,"Act of Treason",1);
        addToHand(P,"Threaten",1);
        addToHand(P,"Slave of Bolas",1);
        addToHand(P,"Traitorous Blood",1);
        addToHand(P,"Zealous Conscripts",1);
        addToHand(P,"Legacy's Allure",1);
        addToHand(P,"Custody Battle",1);
        addToHand(P,"Thalakos Deceiver",1);
        addToHand(P,"Keiga, the Tide Star",1);
        addToHand(P,"Mark of Mutiny",1);


        P = opponent;

        P.setLife(20);
        addToLibrary(P, "Plains", 10);
        createPermanent(game,P,"Rupture Spire",false,8);
        createPermanent(game,P,"Grizzly Bears",false,3);
        createPermanent(game,P,"Helm of Kaldra",false,1);

        return game;
    }
}
