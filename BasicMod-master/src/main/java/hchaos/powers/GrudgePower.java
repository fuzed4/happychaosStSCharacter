package hchaos.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;

import java.util.Iterator;

import static hchaos.HChaos.makeID;

public class GrudgePower extends BasePower {
    public static final String ID = makeID("GrudgeP");
    private static final AbstractPower.PowerType type = AbstractPower.PowerType.BUFF;

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    public GrudgePower(AbstractCreature owner, int amount) {
        super(ID, type, false, owner, amount);
    }
}
