package hchaos.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static hchaos.HChaos.makeID;

public class ConcentrationPower extends BasePower implements CloneablePowerInterface {

    public static final String ID = makeID("Concentration");
    private static final AbstractPower.PowerType type = AbstractPower.PowerType.BUFF;
    public static int amount;


    public ConcentrationPower(AbstractCreature owner, int amount) {
        super(ID, type,true, owner, amount);
    }

    @Override
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount == 0){
            addToBot(new RemoveSpecificPowerAction(owner, owner, "Concentration"));
        }
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
        this.amount += 2;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    @Override
    public AbstractPower makeCopy() {
        return new ConcentrationPower(owner, amount);
    }
}
