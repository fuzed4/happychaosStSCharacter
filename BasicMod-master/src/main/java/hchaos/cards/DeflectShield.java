package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.powers.actions.DeflectShieldAction;
import hchaos.util.CardStats;

public class DeflectShield extends BaseCard {

    public static final String ID = makeID(DeflectShield.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    public DeflectShield() {
        super(ID, info);
        setBlock(10, 4);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DeflectShieldAction(this.block, m));
        if (p.currentBlock <= 0){
            this.addToBot(new ExhaustAction(1, true));
        }
    }
}
