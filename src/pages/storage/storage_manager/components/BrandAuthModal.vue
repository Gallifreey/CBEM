<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-modal v-model:open="openE" title="授权新品牌" width="50%">
    <a-form :model="formState"
    :label-col="{ span: 8 }"
    :wrapper-col="{ span: 10 }"
    >
      <a-form-item name="name" label="品牌名称" :rules="[{ required: true, message: '请输入品牌名称' }]">
        <a-input v-model:value="formState.name" required></a-input>
      </a-form-item>
      <a-form-item name="picture" label="品牌缩略图">
        <a-upload>

        </a-upload>
      </a-form-item>
    </a-form>
  </a-modal>
</template>
<script lang="ts" setup>
const props = defineProps({
  open: {
    type: Boolean,
    default: false
  }
})
const emits = defineEmits(['update:open'])
const openE = useVModel(props, 'open', emits)
interface FormState{
  name: string,
  picture: string
}
const formState = ref<FormState>({
  name: "",
  picture: ""
})
</script>
<style lang="less" scoped>

</style>