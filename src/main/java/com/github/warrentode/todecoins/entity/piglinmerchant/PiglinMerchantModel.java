package com.github.warrentode.todecoins.entity.piglinmerchant;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class PiglinMerchantModel<T extends PiglinMerchant> extends HierarchicalModel<T> implements ArmedModel, HeadedModel {
    public final ModelPart root;
    public final ModelPart body;
    public final ModelPart backpack;
    public final ModelPart backpackBoneBase;
    public final ModelPart boneWart1;
    public final ModelPart boneWart2;
    public final ModelPart boneWart3;
    public final ModelPart head;
    public final ModelPart noseBone;
    public final ModelPart rightEar;
    public final ModelPart leftEar;
    public final ModelPart headWart1;
    public final ModelPart headWart2;
    public final ModelPart armRight;
    public final ModelPart handRight;
    public final ModelPart armLeft;
    public final ModelPart handLeft;
    public final ModelPart legRight;
    public final ModelPart legLeft;
    boolean isOfferingItem;

    public PiglinMerchantModel(@NotNull ModelPart part) {
        this.root = part.getChild("root");
        this.body = this.root.getChild("body");
        this.backpack = this.body.getChild("backpack");
        this.backpackBoneBase = this.backpack.getChild("backpackBoneBase");
        this.boneWart1 = this.backpackBoneBase.getChild("netherwart1");
        this.boneWart2 = this.backpackBoneBase.getChild("netherwart2");
        this.boneWart3 = this.backpackBoneBase.getChild("netherwart3");
        this.head = this.body.getChild("head");
        this.noseBone = this.head.getChild("noseBone");
        this.rightEar = this.head.getChild("rightEar");
        this.leftEar = this.head.getChild("leftEar");
        this.headWart1 = this.head.getChild("netherwart4");
        this.headWart2 = this.head.getChild("netherwart5");
        this.armRight = this.body.getChild("armRight");
        this.handRight = this.armRight.getChild("handRight");
        this.armLeft = this.body.getChild("armLeft");
        this.handLeft = this.armLeft.getChild("handLeft");
        this.legRight = this.root.getChild("legRight");
        this.legLeft = this.root.getChild("legLeft");
    }

    public static @NotNull LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition root = partDefinition.addOrReplaceChild("root", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(),
                PartPose.offset(0.0F, 6.0574F, -0.3817F));

        PartDefinition armorBody_r1 = body.addOrReplaceChild("armorBody_r1",
                CubeListBuilder.create()
                        .texOffs(0, 99)
                        .addBox(-6.0F, -24.0F, -2.0F, 12.0F, 13.0F, 4.0F,
                                new CubeDeformation(0.26F))
                        .texOffs(36, 21)
                        .addBox(-6.0F, -24.0F, -2.0F, 12.0F, 13.0F, 4.0F,
                                new CubeDeformation(0.25F))
                        .texOffs(68, 21)
                        .addBox(-6.0F, -24.0F, -2.0F, 12.0F, 13.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 16.9426F, 4.3817F, 0.2531F, 0.0F, 0.0F));

        PartDefinition backpack = body.addOrReplaceChild("backpack", CubeListBuilder.create(),
                PartPose.offset(0.0F, -7.3109F, 3.8352F));

        PartDefinition bedroll_r1 = backpack.addOrReplaceChild("bedroll_r1",
                CubeListBuilder.create()
                        .texOffs(0, 38)
                        .addBox(-7.0F, -7.0F, 1.5F, 14.0F, 5.0F, 5.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(38, 38).addBox(-7.0F, -2.0F, 6.5F, 14.0F, 8.0F, 3.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(0, 0)
                        .addBox(-7.0F, -2.0F, 1.5F, 14.0F, 16.0F, 5.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.2535F, -5.4536F, 0.2618F, 0.0F, 0.0F));

        PartDefinition backpackBoneBase = backpack.addOrReplaceChild("backpackBoneBase", CubeListBuilder.create(),
                PartPose.offset(0.0F, 1.2535F, -9.4536F));

        PartDefinition rightChain_r1 = backpackBoneBase.addOrReplaceChild("rightChain_r1",
                CubeListBuilder.create()
                        .texOffs(46, 90)
                        .addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(52, 90)
                        .addBox(9.0F, -1.9F, 0.0F, 2.0F, 4.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, -1.5F, 3.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition backPackBoneEndRight_r1 = backpackBoneBase.addOrReplaceChild("backPackBoneEndRight_r1",
                CubeListBuilder.create()
                        .texOffs(22, 90)
                        .addBox(-11.0F, -5.0F, -0.5F, 2.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(30, 90)
                        .addBox(9.0F, -5.0F, -0.5F, 2.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(72, 38)
                        .addBox(-9.0F, -4.0F, -0.5F, 18.0F, 2.0F, 2.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition netherwart1 = backpackBoneBase.addOrReplaceChild("netherwart1",
                CubeListBuilder.create()
                        .texOffs(0, 90)
                        .addBox(-1.5F, 1.1588F, -1.4683F, 3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(8, 96)
                        .addBox(-0.5F, -0.8412F, -0.4683F, 1.0F, 2.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(7.5F, -3.8393F, 2.4F, -0.8727F, 0.0F, 0.0F));

        PartDefinition netherwart2 = backpackBoneBase.addOrReplaceChild("netherwart2",
                CubeListBuilder.create()
                        .texOffs(56, 81)
                        .addBox(-1.5F, 1.6623F, -0.7022F, 3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(4, 96)
                        .addBox(-0.5F, -0.3377F, 0.2978F, 1.0F, 2.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-7.5F, -4.7F, 2.4F, -0.8727F, 0.0F, 0.0F));

        PartDefinition netherwart3 = backpackBoneBase.addOrReplaceChild("netherwart3",
                CubeListBuilder.create()
                        .texOffs(44, 81)
                        .addBox(-1.5F, 1.2055F, -1.0036F, 3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(0, 96)
                        .addBox(-0.5F, -0.7945F, -0.0036F, 1.0F, 2.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-0.5F, -4.5F, 2.3F, -1.1345F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -0.4884F, -3.4942F, -0.1047F, 0.0F, 0.0F));

        PartDefinition rightTusk_r1 = head.addOrReplaceChild("rightTusk_r1",
                CubeListBuilder.create()
                        .texOffs(12, 96)
                        .addBox(-3.0F, -27.0F, -2.0F, 1.0F, 2.0F, 1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(16, 96)
                        .addBox(2.0F, -27.0F, -2.0F, 1.0F, 2.0F, 1.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(38, 0)
                        .addBox(-5.0F, -33.0F, -1.0F, 10.0F, 8.0F, 8.0F,
                                new CubeDeformation(0.25F))
                        .texOffs(0, 21)
                        .addBox(-5.0F, -33.0F, -1.0F, 10.0F, 8.0F, 8.0F,
                                new CubeDeformation(-0.02F)),
                PartPose.offsetAndRotation(0.0F, 27.5297F, 0.2407F, 0.2531F, 0.0F, 0.0F));

        PartDefinition headParticles = head.addOrReplaceChild("headParticles",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(0.0F, -5.0F, -6.0F, 0.0F, 0.0F, 0.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition noseBone = head.addOrReplaceChild("noseBone", CubeListBuilder.create(),
                PartPose.offset(0.0F, 1.7652F, -7.9718F));

        PartDefinition nose_r1 = noseBone.addOrReplaceChild("nose_r1",
                CubeListBuilder.create()
                        .texOffs(12, 90)
                        .addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2531F, 0.0F, 0.0F));

        PartDefinition noseParticles = noseBone.addOrReplaceChild("noseParticles",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                                new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.7644F, -0.7875F));

        PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create(),
                PartPose.offsetAndRotation(4.5747F, -2.9914F, -5.0034F, 0.0F, 0.0F, -0.6109F));

        PartDefinition earring_r1 = leftEar.addOrReplaceChild("earring_r1",
                CubeListBuilder.create()
                        .texOffs(38, 90)
                        .addBox(0.0F, 2.0F, -5.5F, 3.0F, 3.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-0.7697F, 0.0972F, 4.244F, 0.2531F, 0.2094F, 0.0F));

        PartDefinition leftEar_r1 = leftEar.addOrReplaceChild("leftEar_r1",
                CubeListBuilder.create()
                        .texOffs(10, 81)
                        .addBox(6.0F, -30.0F, 2.0F, 1.0F, 5.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.7697F, 30.0972F, 4.244F, 0.2531F, 0.2094F, 0.0F));

        PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-5.0518F, -2.5684F, -4.6604F, 0.0F, 0.0F, 0.6109F));

        PartDefinition rightEar_r1 = rightEar.addOrReplaceChild("rightEar_r1",
                CubeListBuilder.create()
                        .texOffs(0, 81)
                        .addBox(-4.5F, -30.5F, 2.0F, 1.0F, 5.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(3.4434F, 30.24F, 3.9011F, 0.2531F, -0.2094F, 0.0F));

        PartDefinition netherwart4 = head.addOrReplaceChild("netherwart4",
                CubeListBuilder.create()
                        .texOffs(32, 81)
                        .addBox(-1.5F, 2.9708F, -1.9175F, 3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(62, 90)
                        .addBox(-0.5F, -0.0292F, -0.9175F, 1.0F, 3.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(3.5F, 2.3706F, -3.0116F, 0.1396F, 0.0F, 0.0F));

        PartDefinition netherwart5 = head.addOrReplaceChild("netherwart5",
                CubeListBuilder.create()
                        .texOffs(20, 81)
                        .addBox(-1.5F, 2.9708F, -1.9175F, 3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(58, 90).addBox(-0.5F
                                , -0.0292F, -0.9175F, 1.0F, 3.0F, 1.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-3.5F, 2.3725F, -3.0116F, 0.1396F, 0.0F, 0.0F));

        PartDefinition armLeft = body.addOrReplaceChild("armLeft", CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.6282F, -6.3536F, -1.0862F, -0.1309F, 0.0F, -0.1745F));

        PartDefinition armorArmLeft_r1 = armLeft.addOrReplaceChild("armorArmLeft_r1",
                CubeListBuilder.create()
                        .texOffs(40, 99)
                        .addBox(4.2319F, -24.6107F, 0.5941F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.26F))
                        .texOffs(0, 65)
                        .addBox(4.2319F, -24.6107F, 0.5941F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.25F))
                        .texOffs(16, 65)
                        .addBox(4.2319F, -24.6107F, 0.5941F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.2063F, 25.0908F, 2.8874F, 0.2533F, -0.0167F, -0.0079F));

        PartDefinition armRight = body.addOrReplaceChild("armRight", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-6.7051F, -5.1656F, -1.0745F, -0.1309F, 0.0F, 0.1745F));

        PartDefinition armorArmRight_r1 = armRight.addOrReplaceChild("armorArmRight_r1",
                CubeListBuilder.create()
                        .texOffs(40, 99)
                        .addBox(-7.9762F, -24.6111F, 1.1026F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.26F))
                        .texOffs(32, 65)
                        .addBox(-7.9762F, -24.6111F, 1.1026F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.25F))
                        .texOffs(48, 65)
                        .addBox(-7.9762F, -24.6111F, 1.1026F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0909F, 24.0913F, 2.744F, 0.2538F, -0.0612F, -0.0168F));

        PartDefinition legLeft = root.addOrReplaceChild("legLeft",
                CubeListBuilder.create()
                        .texOffs(16, 49)
                        .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(0, 49).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.25F))
                        .texOffs(84, 49)
                        .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.26F))
                        .texOffs(64, 49)
                        .addBox(-2.0F, 7.0F, -2.0F, 4.0F, 4.0F, 4.0F,
                                new CubeDeformation(0.27F)),
                PartPose.offset(3.4F, 13.0F, 1.5F));

        PartDefinition legRight = root.addOrReplaceChild("legRight",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.0F))
                        .texOffs(32, 49)
                        .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.25F))
                        .texOffs(84, 64).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                                new CubeDeformation(0.26F))
                        .texOffs(64, 64)
                        .addBox(-2.0F, 7.0F, -2.0F, 4.0F, 4.0F, 4.0F,
                                new CubeDeformation(0.27F)),
                PartPose.offset(-3.4F, 13.0F, 1.5F));

        // Right hand (main hand)
        PartDefinition handRight = armRight.addOrReplaceChild("handRight",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-1.5F, 11.5F, 0.0F)); // X, Y, Z pivot
        // Left hand (off-hand)
        PartDefinition handLeft = armLeft.addOrReplaceChild("handLeft",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(1.5F, 11.5F, 0.0F)); // X, Y, Z pivot

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float swingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float time = ageInTicks - (float) entity.tickCount;

        float angle = ((float) Math.PI / 6F);
        float angle1 = ageInTicks * 0.1F + limbSwing * 0.5F;
        float angle2 = 0.08F + swingAmount * 0.4F;

        this.leftEar.zRot = (-1 * angle) - Mth.cos(angle1 * 1.2F) * angle2;
        this.rightEar.zRot = angle + Mth.cos(angle1) * angle2;

        float headXRot = this.head.xRot;
        float headYRot = this.head.yRot;

        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animate(entity.defaultAnimationState, PiglinMerchantAnimation.DEFAULT, ageInTicks);
        this.animate(entity.walkLegsOnlyAnimationState, PiglinMerchantAnimation.WALK_LEGS_ONLY, ageInTicks);
        this.animate(entity.walkAnimationState, PiglinMerchantAnimation.WALK, ageInTicks);
        this.animate(entity.idleAnimationState, PiglinMerchantAnimation.IDLE, ageInTicks);
        this.animate(entity.danceAnimationState, PiglinMerchantAnimation.DANCE, ageInTicks);
        this.animate(entity.meleeLeftAnimationState, PiglinMerchantAnimation.MELEE_LEFT, ageInTicks);
        this.animate(entity.meleeRightAnimationState, PiglinMerchantAnimation.MELEE_RIGHT, ageInTicks);
        this.animate(entity.deathAnimationState, PiglinMerchantAnimation.DEATH, ageInTicks);
        this.animate(entity.offerLeftAnimationState, PiglinMerchantAnimation.OFFER_LEFT, ageInTicks);
        this.animate(entity.offerRightAnimationState, PiglinMerchantAnimation.OFFER_RIGHT, ageInTicks);

        // Set flag based on entity state
        this.isOfferingItem = entity.isOfferingItem();
    }

    private void animateHeadLookTarget(float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
    }

    private ModelPart getArm(HumanoidArm arm) {
        return arm == HumanoidArm.LEFT ? this.armLeft : this.armRight;
    }

    @Override
    public void translateToHand(@NotNull HumanoidArm arm, @NotNull PoseStack poseStack) {
        this.getArm(arm).translateAndRotate(poseStack);
        /** this translate setting is relative to the hand,
         * facing the same way as the merchant
         * x = left (+) / right (-)
         * y = front (+) / back (-)
         * z = down (+) / up (-)
         */

        // Only tweak position for the "offer" animation
        if (isOfferingItem) {
            poseStack.translate(0, 0.29, 0.5);
        }
        else {
            // default offset for when arm is down
            poseStack.translate(0, 0.5, 0.2);
        }
    }

    @Override
    public @NotNull ModelPart getHead() {
        return this.head;
    }

    @Override
    public @NotNull ModelPart root() {
        return this.root;
    }
}