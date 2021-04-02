package games.dicemonastery;

import core.components.Component;
import games.dicemonastery.DiceMonasteryConstants.Resource;
import utilities.Utils;

import java.util.Objects;

public class MarketCard extends Component {

    public final int calf_skin;
    public final int grain;
    public final int beer;
    public final int mead;
    public final int candle;
    public final Resource pigmentType;
    public final int pigmentPrice;

    public MarketCard(int calf, int grain, int beer, int mead, int candle, int pigmentPrice, Resource pigmentType) {
        super(Utils.ComponentType.CARD, "Market Card");
        this.calf_skin = calf;
        this.grain = grain;
        this.beer = beer;
        this.mead = mead;
        this.candle = candle;
        this.pigmentType = pigmentType;
        this.pigmentPrice = pigmentPrice;
    }

    @Override
    public Component copy() {
        return this;  // immutable
    }

    @Override
    public String toString() {
        return String.format("CalfSkin: %d, Grain: %d, %s: %d, Beer: %d, Mead: %d, Candle: %d",
                calf_skin, grain, pigmentType, pigmentPrice, beer, mead, candle);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MarketCard) {
            MarketCard other = (MarketCard) o;
            return other.pigmentPrice == pigmentPrice && other.pigmentType == pigmentType &&
                    other.calf_skin == calf_skin && other.grain == grain &&
                    other.beer == beer && other.mead == mead && other.candle == candle;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beer, mead, candle, calf_skin, grain, pigmentPrice, pigmentType);
    }
}
