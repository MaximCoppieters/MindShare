package com.pxl.mindshare.repo;

import java.util.HashMap;
import java.util.Map;

public class FeelingsRepository {
    private static final FeelingsRepository instance = new FeelingsRepository();
    private Map<String, String> colorsByFeeling;

    public static FeelingsRepository getInstance() {
        return instance;
    }

    private FeelingsRepository() {
        colorsByFeeling = new HashMap<>();
    }

    private void initializeColorsByFeelings() {
        colorsByFeeling.put("black", "The color black is often described as a \"powerful\" color, which might be the reason why black is the most popular color for luxury vehicles. People often describe the color as sexy, powerful, mysterious, and even ominous.");
        colorsByFeeling.put("blue", "It symbolizes trust, loyalty, wisdom, confidence, intelligence, faith, truth, and heaven. Blue is considered beneficial to the mind and body. It slows human metabolism and produces a calming effect. Blue is strongly associated with tranquility and calmness.");
        colorsByFeeling.put("green", "Green, the color of life, renewal, nature, and energy, is associated with meanings of growth, harmony, freshness, safety, fertility, and environment. Green is also traditionally associated with money, finances, banking and ambition.");
        colorsByFeeling.put("red", "Red is a bold, attention-getting color, so preferring this type of car might mean you want to project an image of power, action, and confidence.");
        colorsByFeeling.put("pink", "Rose pink is the universal color of love. It is mature, feminine and intuitive. Hot pink is passionate, playful, sensual and loving. It radiates warmth, joy and a love for life.");
        colorsByFeeling.put("yellow", "According to the experts, driving a yellow vehicle might mean that you are a happy person in general and perhaps a bit more willing than the average person to take risks.");
        colorsByFeeling.put("purple", "Purple combines the calm stability of blue and the fierce energy of red. The color purple is often associated with royalty, nobility, luxury, power, and ambition. Purple also represents meanings of wealth, extravagance, creativity, wisdom, dignity, grandeur, devotion, peace, pride, mystery, independence, and magic.");
        colorsByFeeling.put("cyan", "Like blue they promote and encourage peace and calmness, clear thinking and thoughtfulness. Other things asscoiated with cyan are emotional control or repression of emotions. To top it off, the color cyan also induces cleanliness.");
        colorsByFeeling.put("grey", " The experts suggest that people who drive gray cars don't want to stand out and instead prefer something a bit more subtle.");
    }


    public String getColorFeeling(String chosenColorName) {
        return colorsByFeeling.get(chosenColorName);
    }
}
