package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.powers.BMagPower;
import hchaos.util.CardStats;

public class BackupMagazine extends BaseCard {

    public static final String ID = makeID(BackupMagazine.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    public BackupMagazine() {
        super(ID, info);
        setMagic(1, 0);
        setInnate(false, true);
        this.cardsToPreview = new Blast();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BMagPower(p, this.magicNumber)));
    }
}