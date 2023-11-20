package hchaos.powers;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import hchaos.cards.Blast;

import static hchaos.HChaos.makeID;

public class BMagPower extends BasePower {

    public static final String ID = makeID("BackupMagazine");
    private static final AbstractPower.PowerType type = AbstractPower.PowerType.BUFF;

    public BMagPower(AbstractCreature owner, int amount) {
        super(ID, type, false, owner, amount);
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
        addToBot(new MakeTempCardInHandAction(new Blast(), this.amount));
    }
}
