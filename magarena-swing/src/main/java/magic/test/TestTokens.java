package magic.test;

import magic.model.MagicDeckProfile;
import magic.model.MagicDuel;
import magic.model.MagicGame;
import magic.model.MagicPlayer;
import magic.model.MagicPlayerDefinition;
import magic.model.phase.MagicMainPhase;

class TestTokens extends TestGameBuilder {
    /**
     * Put all the tokens in the game in the battlefield
     */
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

        player.setLife(1);
        addToLibrary(player,"Plains",10);
        addToLibrary(player,"Grizzly Bears",10);
        createPermanent(game,player,"Rupture Spire",false,10);
        createPermanent(game,player,"Geist of Saint Traft",false,1);
        // createPermanent(game,player,"Kemba, Kha Regent",false,1);
        // createPermanent(game,player,"Darksteel Axe",false,1);
        createPermanent(game,player,"Awakening Zone",false,1);
        createAllTokens(game,player);

        opponent.setLife(1);
        createPermanent(game,opponent,"Grizzly Bears",false,1);
        addToLibrary(opponent,"Island",10);

        return game;
    }
}
