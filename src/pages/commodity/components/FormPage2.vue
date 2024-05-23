<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <a-form :model="bomE" :rules="rules"  :label-col="{ span: 8 }" :wrapper-col="{ span: 8 }">
      <a-form-item name="bomName" label="BOM名称">
        <a-input v-model:value="bom.bomName"/>
      </a-form-item>
      <a-form-item name="parentBomID" label="父BOM">
        <a-input v-model:value="bom.parentBomID"/>
      </a-form-item>
      <a-form-item name="childrenBomID" label="子BOM">
      
      </a-form-item>
      <a-form-item name="assemblePrice" label="组装价">
        <a-input-number v-model:value="bom.assemblePrice"/>
      </a-form-item>
      <a-form-item name="splitPrice" label="拆分价">
        <a-input-number v-model:value="bom.splitPrice" />
      </a-form-item>
      <a-form-item name="costFomula" label="成本核算方式">
        <a-input v-model:value="bom.costFomula" />
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts" setup>
import { CommodityBOMData, CommodityHolderValue } from '@/types/form'
import type { Rule } from 'ant-design-vue/es/form';

const props = defineProps({
  bom: {
    type: Object as PropType<CommodityBOMData>,
    default: CommodityHolderValue.bom
  }
})
const emits = defineEmits(['update:bom'])
const bomE = useVModel(props, 'bom', emits)

const rules: Record<string, Rule[]> = {
  bomName: [
    {
      required: true,
      message: '请输入BOM商品名称'
    }
  ],
  parentBomID: [
    {
      required: true,
      message: '请选择父BOM商品'
    }
  ],
  childrenBomID: [
    {
      required: true,
      message: '请选择子BOM商品'
    }
  ],
  assemblePrice: [
    {
      required: true,
      message: '请输入组装价'
    }
  ],
  splitPrice: [
    {
      required: true,
      message: '请输入拆分价'
    }
  ],
  costFomula: [
    {
      required: true,
      message: '请输入成本核算方式'
    }
  ]
}
</script>
<style lang="less" scoped>

</style>