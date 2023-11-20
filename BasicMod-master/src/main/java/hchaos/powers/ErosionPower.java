package hchaos.powers;


import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static hchaos.HChaos.makeID;

public class ErosionPower extends BasePower {

    public static final String ID = makeID("Erosion");
    private static final PowerType type = PowerType.DEBUFF;

    public ErosionPower(AbstractCreature owner, int amount) {
        super(ID, type, true, owner, amount);
    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount == 0) {
            addToBot(new RemoveSpecificPowerAction(owner, owner, "Concentration"));
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        this.amount += 1;
    }

    @Override
    public float atDamageReceive(float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.NORMAL) {
            return damage + this.amount;
        } else {
            return damage;
        }
    }
}