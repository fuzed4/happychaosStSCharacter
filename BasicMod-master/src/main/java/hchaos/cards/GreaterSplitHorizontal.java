package hchaos.cards;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class GreaterSplitHorizontal extends BaseCard {
    public static final String ID = makeID(GreaterSplitHorizontal.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ALL_ENEMY,
            1);

    public GreaterSplitHorizontal() {
        super(ID, info);
        setDamage(500, 200);
        this.isMultiDamage = true;

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
     addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }
}
