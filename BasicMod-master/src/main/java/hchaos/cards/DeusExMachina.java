package hchaos.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.PummelDamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import hchaos.character.HChaos;
import hchaos.powers.ConcentrationPower;
import hchaos.util.CardStats;

public class DeusExMachina extends BaseCard {

    public static final String ID = makeID(DeusExMachina.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            3);

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 1;


    public DeusExMachina() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(11, 0);
        this.cardsToPreview = new Blast();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < this.magicNumber; ++i) {
            addToBot(new PummelDamageAction(m, new DamageInfo(p, damage, damageTypeForTurn)));
        }
        addToBot(new MakeTempCardInHandAction(new Blast(), 6));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, -2)));
        addToBot(new ApplyPowerAction(p, p, new LoseStrengthPower(p, -2)));
        addToBot(new ApplyPowerAction(p, p, new ConcentrationPower(p, -15)));
    }
}
