package hchaos.powers;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;

import static basemod.helpers.CardTags.hasTag;
import static hchaos.CustomTags.*;
import static hchaos.HChaos.makeID;

public class TuningStatePower extends BasePower {

    public static final String ID = makeID("Attuned");
    private static final AbstractPower.PowerType type = AbstractPower.PowerType.BUFF;

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1] +  DESCRIPTIONS[2] +  DESCRIPTIONS[3] +  DESCRIPTIONS[4] +  DESCRIPTIONS[5];
    }

    public TuningStatePower(AbstractCreature owner, int amount) {
        super(ID, type,true, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount <= 0){
            addToBot(new RemoveSpecificPowerAction(owner, owner, TuningStatePower.ID));
            }
        }
    public void onUseCard(AbstractCard c, UseCardAction a){
        // element card played with tuning state on > finds effect correlated with that element
        if ((c.hasTag(ELEMENTAL) && this.amount == 1)){
            if (c.hasTag(FIRE)){
                addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new VigorPower(AbstractDungeon.player,2)));
            }
            if (c.hasTag(THUNDER)){
                addToBot(new DamageAllEnemiesAction(AbstractDungeon.player, 3, DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.LIGHTNING));
            }
            if (c.hasTag(WIND)){
                addToBot(new DamageRandomEnemyAction(new DamageInfo(owner, 5, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            }
            if (c.hasTag(WATER)){
                addToBot(new GainBlockAction(AbstractDungeon.player, 3));
            }
        }
        //cards that ARE NOT element cards make it go bye
        if(!c.hasTag(ELEMENTAL) && this.amount == 1){
            addToBot(new RemoveSpecificPowerAction(owner, owner, TuningStatePower.ID));
        }
    }

}
