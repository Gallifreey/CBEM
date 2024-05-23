<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <a-form :model="skuE" :rules="rules"  :label-col="{ span: 8 }" :wrapper-col="{ span: 8 }">
      <a-form-item name="skuColor" label="SKU商品色系">
        <a-input v-model:value="skuE.skuColor" :style="{borderColor: skuE.skuColor}" />
      </a-form-item>
      <a-form-item name="skuSize" label="SKU商品规格">
        <a-input v-model:value="skuE.skuSize[0]" style="width: 50px;"/> × <a-input v-model:value="skuE.skuSize[1]" style="width: 50px;"/> × <a-input v-model:value="skuE.skuSize[2]" style="width: 50px;"/> m³
      </a-form-item>
      <a-form-item name="skuBarCodeMsg" label="SKU商品条形码">
        <a-input v-model:value="skuE.skuBarCodeMsg" @change="handleBRInputChange"/>
        <svg class="barcode"></svg>
      </a-form-item>
      <a-form-item name="skuAssociatedID" label="关联SKU商品">
        <a-input-number v-model:value="skuE.skuAssociatedID" />
      </a-form-item>
      <a-form-item name="skuWeight" label="SKU商品重量">
        <a-input-number v-model:value="skuE.skuWeight" />
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts" setup>
import { CommoditySKUData, CommodityHolderValue } from '@/types/form'
import type { Rule } from 'ant-design-vue/es/form';
import JsBarcode from 'jsbarcode';

const props = defineProps({
  sku: {
    type: Object as PropType<CommoditySKUData>,
    default: CommodityHolderValue.sku
  }
})
const emits = defineEmits(['update:sku'])
const skuE = useVModel(props, 'sku', emits)

const rules: Record<string, Rule[]> = {
  skuBarCodeMsg: [
    {
      required: true,
      message: '请录入SKU商品条形码信息'
    }
  ],
  skuAssociatedID: [
    {
      required: true,
      message: '请关联SKU商品'
    }
  ],
  skuWeight: [
    {
      required: true,
      message: '请输入SKU商品重量'
    }
  ]
}

const handleBRInputChange = (_: any) => {
  generateBRCode(skuE.value.skuBarCodeMsg)
}

const generateBRCode = (msg: string) => {
  JsBarcode('.barcode', msg, {
    format: 'CODE39',
    width:1,
    height:40,
    displayValue:true,
    fontSize:15,
    margin:15,
    background: "transparent"
  })
}
</script>
<style lang="less" scoped>

</style>