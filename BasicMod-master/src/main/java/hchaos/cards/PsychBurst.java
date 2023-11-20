package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class PsychBurst extends BaseCard {

    public static final String ID = makeID(PsychBurst.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            0
    );

    public PsychBurst() {
        super(ID, info);
        setBlock(23,5);
        setEthereal(true, true);
        setMagic(2,0);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, this.magicNumber, false)));
        addToBot(new GainBlockAction(p, p, this.block));
    }
}
