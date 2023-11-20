package hchaos.cards;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.powers.actions.DivergentFistAction;
import hchaos.util.CardStats;

public class DivergentFist extends BaseCard {

    public static final String ID = makeID(DivergentFist.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    public DivergentFist() {
        super(ID, info);
        setDamage(5, 0);
        setMagic(10, 5);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
       addToBot(new DivergentFistAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), this.magicNumber));
    }
}
