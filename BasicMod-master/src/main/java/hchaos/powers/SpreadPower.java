package hchaos.powers;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.cards.Grudge;

import static hchaos.HChaos.makeID;

public class SpreadPower extends BasePower {

    public static final String ID = makeID(SpreadPower.class.getSimpleName());
    private static final PowerType type = PowerType.DEBUFF;

    public SpreadPower(AbstractCreature owner, int amount) {
        super(ID, type, false, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        this.flash();
        addToBot(new DamageAction(this.owner, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.HP_LOSS)));
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner) {
            this.flash();
            this.addToTop(new ApplyPowerAction(info.owner, AbstractDungeon.player, (new CursePower(info.owner,10))));
            this.amount -= 1;
        }
        if (this.amount == 0) {
            addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, SpreadPower.ID));
        }

        return damageAmount;
        }
    }
