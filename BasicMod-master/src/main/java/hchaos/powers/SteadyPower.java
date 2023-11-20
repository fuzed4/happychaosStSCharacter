package hchaos.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import hchaos.cards.Blast;

import java.util.Iterator;

import static hchaos.HChaos.makeID;

public class SteadyPower extends BasePower {
    public static final String ID = makeID("Steady");
    private static final AbstractPower.PowerType type = AbstractPower.PowerType.BUFF;

    public SteadyPower(AbstractCreature owner, int amount) {
        super(ID, type, false, owner, amount);
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        this.updateExistingBlasts(3);
        if (this.amount == 0) {
            this.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, SteadyPower.ID));
            this.updateExistingBlasts(1);
        }
    }
    private void updateExistingBlasts(int SteadyModifier) {

        Iterator var1 = AbstractDungeon.player.hand.group.iterator();

        AbstractCard c;
        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof Blast) {
                if (!c.upgraded) {
                    c.baseDamage = 4 * SteadyModifier;
                } else {
                    c.baseDamage = 7 * SteadyModifier;
                }
            }
        }

        var1 = AbstractDungeon.player.drawPile.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof Blast) {
                if (!c.upgraded) {
                    c.baseDamage = 4 * SteadyModifier;
                } else {
                    c.baseDamage = 7 * SteadyModifier;
                }
            }
        }

        var1 = AbstractDungeon.player.discardPile.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof Blast) {
                if (!c.upgraded) {
                    c.baseDamage = 4 * SteadyModifier;
                } else {
                    c.baseDamage = 7 * SteadyModifier ;
                }
            }
        }

        var1 = AbstractDungeon.player.exhaustPile.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c instanceof Blast) {
                if (!c.upgraded) {
                    c.baseDamage = 4 * SteadyModifier;
                } else {
                    c.baseDamage = 7 * SteadyModifier;
                }
            }
        }

    }

    public void onDrawOrDiscard() {
        int SteadyModifier = 3;
        Iterator var1 = AbstractDungeon.player.hand.group.iterator();

        while(var1.hasNext()) {
            AbstractCard c = (AbstractCard)var1.next();
            if (c instanceof Blast) {
                if (!c.upgraded) {
                    c.baseDamage = 4 * SteadyModifier;
                } else {
                    c.baseDamage = 7 * SteadyModifier;
                }
            }
        }

    }
}

