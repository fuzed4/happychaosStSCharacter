package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class Reload extends BaseCard{

    public static final String ID = makeID(Reload.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            0
    );

    private static final int magic = 1;
    private static final int magic_up = 1;
    public Reload() {
        super(ID, info);
        setMagic(magic, magic_up);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Blast(), this.magicNumber));
    }
}
