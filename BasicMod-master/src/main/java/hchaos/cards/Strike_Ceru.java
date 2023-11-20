package hchaos.cards;

import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

public class Strike_Ceru extends BaseCard{
    public static final String ID = makeID(Strike_Ceru.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 2;

    public Strike_Ceru() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CardTags.STRIKE);
        tags.add(BaseModCardTags.BASIC_STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}
