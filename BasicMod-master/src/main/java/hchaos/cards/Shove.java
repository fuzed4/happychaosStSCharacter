package hchaos.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class Shove extends BaseCard {
    public static final String ID = makeID(Shove.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 3;

    public Shove() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setExhaust(true, true);
        setMagic(2,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, -this.magicNumber)));
    }
}

