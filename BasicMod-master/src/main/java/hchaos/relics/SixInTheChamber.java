package hchaos.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import hchaos.cards.Blast;
import hchaos.character.HChaos;
import hchaos.powers.ConcentrationPower;


import static hchaos.HChaos.makeID;

public class SixInTheChamber extends BaseRelic {
    private static final String NAME = "SixInTheChamber";

    public static final String ID = makeID(NAME);

    private static final RelicTier RARITY = RelicTier.STARTER;

    private static final LandingSound SOUND = LandingSound.CLINK;

    public SixInTheChamber() {
        super(ID, NAME, HChaos.Enums.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            ++this.counter;

            if (this.counter == 6) {
                this.counter = 0;
                this.flash();
                this.pulse = false;
            }
            if (this.counter == 5) {
                addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
                addToTop(new MakeTempCardInHandAction(new Blast(), 1));
                this.pulse = true;
            }
        }
    }
}
