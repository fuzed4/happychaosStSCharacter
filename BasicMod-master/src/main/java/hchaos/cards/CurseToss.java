package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.powers.ConcentrationPower;
import hchaos.powers.CursePower;
import hchaos.util.CardStats;

public class CurseToss extends BaseCard {
    public static final String ID = makeID(CurseToss.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    );

    private static final int MAGIC = 3;
    private static final int MAGICU = 3;

    public CurseToss() {
        super(ID, info);
        setMagic(MAGIC, MAGICU);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new CursePower(m, this.magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new ConcentrationPower(p, 2)));

    }
}