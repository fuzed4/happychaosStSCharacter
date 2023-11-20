package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

import static javassist.compiler.TokenId.BLOCK;

public class Defend_Ceru extends BaseCard{
    public static final String ID = makeID(Defend_Ceru.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            1);

    private static final int baseBlock = 5;
    private static final int UPG_BLOCK = 3;
    public Defend_Ceru() {
        super(ID, info);
        setBlock(baseBlock, UPG_BLOCK);
        tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
    }
}
