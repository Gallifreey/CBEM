<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <a-form :model="metaE" :rules="rules"  :label-col="{ span: 8 }" :wrapper-col="{ span: 8 }">
      <a-form-item name="picture" label="上传商品图片">
        <a-upload
        v-model:file-list="fileList"
        name="picture"
        list-type="picture-card"
        @change="handleChange"
        >
        <img v-if="metaE.picture" :src="metaE.picture" alt="avatar" />
        <div v-else>
          <PlusOutlined />
          <div class="ant-upload-text">Upload</div>
        </div>
        </a-upload>
      </a-form-item>
      <a-form-item name="barCodeMsg" label="商品条形码">
        <a-input v-model:value="metaE.barCodeMsg" @change="handleBRInputChange"/>
        <svg class="barcode"></svg>
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts" setup>
import { CommodityMetaData, CommodityHolderValue } from '@/types/form'
import type { Rule } from 'ant-design-vue/es/form';
import JsBarcode from 'jsbarcode';
import { PlusOutlined } from '@ant-design/icons-vue';
import type { UploadChangeParam } from 'ant-design-vue';

const props = defineProps({
  meta: {
    type: Object as PropType<CommodityMetaData>,
    default: CommodityHolderValue.meta
  }
})
const emits = defineEmits(['update:meta'])
const loading = ref<boolean>(false);
const metaE = useVModel(props, 'meta', emits)
const fileList = ref([]);
const rules: Record<string, Rule[]> = {
  barCodeMsg: [
    {
      required: true,
      message: '请录入商品条形码信息'
    }
  ]
}
const handleBRInputChange = (_: any) => {
  generateBRCode(metaE.value.barCodeMsg)
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
function getBase64(img: Blob, callback: (base64Url: string) => void) {
  const reader = new FileReader();
  reader.addEventListener('load', () => callback(reader.result as string));
  reader.readAsDataURL(img);
}
const handleChange = (info: UploadChangeParam) => {
  if (info.file.status === 'uploading') {
    loading.value = true;
    return;
  }
  if (info.file.status === 'done') {
    getBase64(info.file.originFileObj, (base64Url: string) => {
      console.log(base64Url)
      metaE.value.picture = base64Url;
      loading.value = false;
    });
  }
  if (info.file.status === 'error') {
    loading.value = false;
  }
};
</script>
<style lang="less" scoped>

</style>