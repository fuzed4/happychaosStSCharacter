package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.powers.CatalystPrimerPower;
import hchaos.util.CardStats;

public class CatalystPrimers extends BaseCard {

    public static final String ID = makeID(CatalystPrimers.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    public CatalystPrimers() {
        super(ID, info);
        setMagic(5, 3);
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(new ApplyPowerAction(p, p, new CatalystPrimerPower(p, this.magicNumber)));
    }
}
