<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-tabs v-model:active-key="tab">
        <a-tab-pane tab="经营总览" key="0" />
        <a-tab-pane tab="流量分析" key="1" />
        <a-tab-pane tab="客户分析" key="2" />
      </a-tabs>
    </template>
    <Page1 v-if="tab === '0'" />
  </PageContainer>
</template>
<script lang="ts" setup>
import Page1 from "./components/Page1.vue"

const tab = ref("0")
</script>
<style lang="less" scoped>

</style>