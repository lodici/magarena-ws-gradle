package magic.test;

import magic.model.MagicDeckProfile;
import magic.model.MagicDuel;
import magic.model.MagicGame;
import magic.model.MagicPlayer;
import magic.model.MagicPlayerDefinition;
import magic.model.phase.MagicMainPhase;

class TestPopulate extends TestGameBuilder {
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
        addToHand(P, "Eyes in the Skies", 1);
        addToHand(P, "Trostani, Selesnya's Voice", 1);
        addToHand(P, "Vitu-Ghazi Guildmage", 1);
        addToHand(P, "Wayfaring Temple", 1);
        addToHand(P, "Horncaller's Chant", 1);
        addToHand(P, "Druid's Deliverance", 1);

        P = opponent;

        P.setLife(10);
        addToLibrary(P, "Plains", 10);
        createPermanent(game,P,"Rupture Spire",false,8);
        addToHand(P, "Growing Ranks", 1);
        addToHand(P, "Rootborn Defenses", 1);
        addToHand(P, "Sundering Growth", 1);
        addToHand(P, "Trostani's Judgement", 1);
        addToHand(P, "Coursers' Accord", 1);

        return game;
    }
}
