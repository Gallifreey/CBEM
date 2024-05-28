<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-modal v-model:open="openE" title="结算" width="60%">
    <a-steps :items="[
      {
        title: '确认订单信息'
      },
      {
        title: '填写转账信息'
      },
      {
        title: '确认转账信息'
      },
      {
        title: '完成'
      }
    ]" :current="currentStep">
    </a-steps>
    <div class="content">
      <template v-if="currentStep === 0">
        <a-form
        :label-col="{ span: 10 }"
        :wrapper-col="{ span: 16 }"
        >
          <a-form-item label="商品名称">
            /*/*
          </a-form-item>
          <a-form-item label="单价">
            ￥ 5.2
          </a-form-item>
          <a-form-item label="数量">
            2
          </a-form-item>
          <a-form-item label="总计">
            ￥ 10.4
          </a-form-item>
          <a-divider />
          <a-form-item label="收款人">
            我
          </a-form-item>
          <a-form-item :wrapper-col="{ offset: 10, span: 16 }">
            <a-button type="primary">下一步</a-button>
          </a-form-item>
        </a-form>
      </template>
    </div>
  </a-modal>
</template>
<script lang="ts" setup>

const props = defineProps({
  open: {
    type: Boolean,
    default: false
  }
})
const currentStep = ref(0)
const emits = defineEmits(['update:open'])
const openE = useVModel(props, 'open', emits)
</script>
<style lang="less" scoped>
.content{
  margin-top: 20px;
}
</style>