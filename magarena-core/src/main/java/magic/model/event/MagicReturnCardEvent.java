package magic.model.event;

import magic.model.MagicCard;
import magic.model.MagicGame;
import magic.model.MagicLocationType;
import magic.model.MagicPlayer;
import magic.model.MagicSource;
import magic.model.action.MagicCardAction;
import magic.model.action.MagicDiscardCardAction;
import magic.model.choice.MagicTargetChoice;

public class MagicReturnCardEvent extends MagicEvent {

    public MagicReturnCardEvent(final MagicSource source,final MagicPlayer player) {
        super(
            source,
            player,
            MagicTargetChoice.A_CARD_FROM_HAND,
            EVENT_ACTION,
            "PN puts a card from his or her hand on top of his or her library."
        );
    }
    
    private static final MagicEventAction EVENT_ACTION=new MagicEventAction() {
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetCard(game,new MagicCardAction() {
                public void doAction(final MagicCard card) {
                    game.doAction(new MagicDiscardCardAction(
                        event.getPlayer(),
                        card,
                        MagicLocationType.TopOfOwnersLibrary
                    ));
                }
            });
        }
    };
}
