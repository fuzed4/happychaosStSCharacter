package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.powers.GrudgePower;
import hchaos.util.CardStats;

public class Grudge extends BaseCard {

    public static final String ID = makeID(Grudge.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    public Grudge() {
        super(ID, info);
        setMagic(7, 0);
        setInnate(false, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new GrudgePower(p, this.magicNumber)));
    }
}
