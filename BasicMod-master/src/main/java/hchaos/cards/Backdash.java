package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class Backdash extends BaseCard{
    public static final String ID = makeID(Backdash.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );

    private static final int magic = 2;
    private static final int magic_upg = 1;

    public Backdash() {
        super(ID, info);
        setMagic(magic, magic_upg);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, this.magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new LoseDexterityPower(p, this.magicNumber)));

    }
}