package hchaos.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class SplitShot extends BaseCard {

    public static final String ID = makeID(SplitShot.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            1
    );

    public SplitShot() {
        super(ID, info);
        setDamage(4, 1);
        setMagic(1, 0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i <= this.magicNumber; ++i){
            addToBot(new DamageAllEnemiesAction(p, this.damage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }
}
