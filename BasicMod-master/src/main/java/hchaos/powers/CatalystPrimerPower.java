package hchaos.powers;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static hchaos.HChaos.makeID;

public class CatalystPrimerPower extends BasePower {

    public static final String ID = makeID("CatalystPrimers");
    private static final AbstractPower.PowerType type = AbstractPower.PowerType.BUFF;

    public CatalystPrimerPower(AbstractCreature owner, int amount) {
        super(ID, type,true, owner, amount);
    }

    @Override
    public void onExhaust(AbstractCard card) {
        addToBot(new DamageRandomEnemyAction(new DamageInfo(owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
    }
}
