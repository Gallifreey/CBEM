<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-modal v-model:open="openE" title="发票预览" width="65%">
    <div class="info-panel">
      <VueOfficeDocx :src="'http://localhost:6678/order-template.docx'"/>
    </div>
    <template #footer></template>
  </a-modal>
</template>
<script lang="ts" setup>
import VueOfficeDocx from '@vue-office/docx'
import '@vue-office/docx/lib/index.css'

const props = defineProps({
  data: {
    type: Object
  },
  open: {
    type: Boolean,
    default: false
  }
})

const emits = defineEmits(['update:open']);
const openE = useVModel(props, 'open', emits);
</script>
<style lang="less" scoped>

</style>